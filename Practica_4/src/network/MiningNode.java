package network;

import interfaces.*;
import notificaciones.*;

import java.util.ArrayList;
import java.util.List;

import block.*;

/**
 * Clase que representa el nodo minero
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public class MiningNode extends Node {
    private int cComputacional;
    private SimpleMining miningMethod;
    private SimpleValidate validateMethod;
    private static List<Block> blocks = new ArrayList<Block>();

    /**
     * Constructor de la clase MiningNode
     * 
     * @param wallet         cartera de divisas
     * @param cComputacional
     */
    public MiningNode(Wallet wallet, int cComputacional) {
        super(wallet);
        this.cComputacional = cComputacional;
        this.miningMethod = null;
        this.validateMethod = null;
    }

    /**
     * Metodo que devuelve el coste computacional
     * 
     * @return coste computacional
     */
    public int getcComputacional() {
        return this.cComputacional;
    }

    /**
     * Metodo que establece el coste computacional
     * 
     * @param cComputacional
     */
    public void setcComputacional(int cComputacional) {
        this.cComputacional = cComputacional;
    }

    /**
     * Metodo que devuelve el metodo de minado
     * 
     * @return SimpleMining
     */
    public SimpleMining getMiningMethod() {
        return this.miningMethod;
    }

    /**
     * Metodo que devuelve el metodo de validacion
     * 
     * @return SimpleValidate
     */
    public SimpleValidate getValidationMethod() {
        return this.validateMethod;
    }

    /**
     * Metodo que establece el metodo de minado
     * 
     * @param simpleMining
     */
    public void setMiningMethod(SimpleMining simpleMining) {
        this.miningMethod = simpleMining;
    }

    /**
     * Metodo que establece el metodo de validacion
     * 
     * @param simpleValidate
     */
    public void setValidationMethod(SimpleValidate simpleValidate) {
        this.validateMethod = simpleValidate;
    }

    /**
     * Metodo que devuelve el bloque anterior
     * 
     * @return Block
     */
    public Block getPreviousBlock() {
        if (blocks.isEmpty() == true) {
            return null;
        }
        return blocks.get(blocks.size() - 1);
    }

    /**
     * Metodo que devuelve el nombre completo del nodo
     * 
     * @return String
     */
    public String fullName() {
        return "@MiningNode#" + String.format("%03d", this.getId());
    }

    /**
     * Metodo que maneja una transaccion
     * 
     * @param tnot notificacion de transaccion
     */
    @Override
    public void handleTransactionNotification(TransactionNotification tnot) {
        Transaction t = tnot.getTransaction();
        IConnectable network = this.getTopParent();

        if (this.getTransactions().contains(t)) {
            System.out.println("[" + this.fullName() + "] Transaction already confirmed: Tx-" + t.getId());
        }

        if (!this.getTransactions().contains(t) && miningMethod != null) {
            Block block = miningMethod.mineBlock(t, this.getPreviousBlock(), this.getWallet().getPublicKey());
            blocks.add(block);
            block.setPreviousBlock(block);

            System.out.println("[" + this.fullName() + "] Mined block: " + block.toString());
            network.broadcast(new ValidateBlockRq(block, this));
        }
    }

    /**
     * Metodo que se encarga de controlar la validacion de bloques
     * 
     * @param validateblockrq peticion de validacion de bloque
     */
    @Override
    public void handleValidateBlockRq(ValidateBlockRq validateblockrq) {
        IConnectable network = this.getTopParent();

        if (this != validateblockrq.getMiningNode()) {
            Block block = validateblockrq.getBlock();
            boolean res = this.validateMethod.validate(miningMethod, block);
            block.setValidated(res);

            ValidateBlockRes validateBlockRes = new ValidateBlockRes(block, res, this.getId());
            System.out.println(
                    String.format(
                            "[" + this.fullName() + "] " +
                                    "Emitted Task: ValidateBlockRes: <b:" +
                                    block.getId() + ", res:" + block.isValidated() + ", src:%03d" + ">",
                            this.getId()));
            network.broadcast(validateBlockRes);
        } else {
            if (validateMethod != null) {
                System.out.println("[" + this.fullName() + "] You cannot validate your own block");
                return;
            }
        }
    }

    /**
     * Metodo toString de la clase MiningNode
     */
    @Override
    public String toString() {
        return this.getWallet() + " | @MiningNode#" + String.format("%03d", this.getId());
    }

}

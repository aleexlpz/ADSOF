package notificaciones;

import block.*;
import interfaces.*;
import network.*;


public class ValidateBlockRes implements IMessage {

    private Block block;
    private boolean res;
    private int src;

    /**
     * Constructor de mensaje de resultado de validar un bloque
     */
    public ValidateBlockRes(Block block, boolean res, int src) {
        this.block = block;
        this.res = res;
        this.src = src;
        System.out.println(this.getMessage());
    }

    /**
     * Devuelve el bloque del mensaje
     *
     * @return el bloque del mensaje
     */
    public Block getBlock() {
        return this.block;
    }

    /**
     * Devuelve el resultado de validar
     *
     * @return el resultado
     */
    public boolean getRes() {
        return this.res;
    }

    /**
     * Devuelve el mensaje
     *
     * @return el mensaje
     */
    @Override
    public String getMessage() {
        return "ValidateBlockRes";
    }

    /**
     * Procesa un nodo
     *
     * @param n nodo que se procesa
     */
    @Override
    public void process(Node n) {
        Transaction transaction = this.block.getTransaction();
        Wallet wallet = n.getWallet();
        String msg1 = "[" + n.fullName() + "] Received Task: " + this + "<b:" + this.block.getId() + ", res:" + this.res
                + ", src:" + n.getId() + ">";
        String msg2 = "[" + n.fullName() + "] Committing transaction: Tx-" + transaction.getId() + " in "
                + n.fullName();
        String msg3 = "[" + n.fullName() + "] -> Tx details: " + transaction;

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);

        if (this.res) {
            if (!n.getTransactions().contains(transaction)) {
                n.addTransaction(transaction);
            }

            if (wallet.getPublicKey() == transaction.getSender()) {
                applyTransaction(wallet, transaction, n);
            } else if (wallet.getPublicKey() == transaction.getReceiver()) {
                applyTransaction(wallet, transaction, n);
            }
        }
    }

    private void applyTransaction(Wallet wallet, Transaction transaction, Node n) {
        String msg = "[" + n.fullName() + "] Applied Transaction: " + transaction;
        System.out.println(msg);

        int balanceChange = (wallet.getPublicKey() == transaction.getSender()) ? -transaction.getValue()
                : transaction.getValue();
        wallet.setBalance(wallet.getBalance() + balanceChange);

        String balanceMsg = "[" + n.fullName() + "] New wallet value: " + wallet;
        System.out.println(balanceMsg);
    }

    /**
     * Informacion de mensaje de resultado de validar
     *
     * @return string de informacion de mensaje
     */
    @Override
    public String toString() {
        return "ValidateBlockRes";
    }
}

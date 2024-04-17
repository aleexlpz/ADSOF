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
     * 
     * @param block bloque a validar
     * @param res   resultado de validar
     * @param src   nodo que envia el mensaje
     * @return mensaje de resultado de validar
     */
    public ValidateBlockRes(Block block, boolean res, int src) {
        this.block = block;
        this.res = res;
        this.src = src;
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

    public int getsrc() {
        return this.src;
    }

    /**
     * Devuelve el mensaje
     *
     * @return el mensaje
     */
    @Override
    public String getMessage() {
        return "ValidateBlockRes ";
    }

    /**
     * Procesa un nodo
     *
     * @param n nodo que se procesa
     */
    @Override
    public void process(Node n) {
        System.out.println(
                String.format(
                        "[" +
                                n.fullName() +
                                "] " +
                                "Received Task: ValidateBlockRes: <b:" +
                                block.getId() +
                                ", res:" +
                                block.isValidated() +
                                ", src:%03d" +
                                ">",
                        src));

        n.handleValidateBlockRes(this);
    }

    /**
     * Informacion de mensaje de resultado de validar
     *
     * @return string de informacion de mensaje
     */
    @Override
    public String toString() {
        return "ValidateBlockRes ";
    }
}

package notificaciones;

import block.*;
import interfaces.*;
import network.*;
/**
 * Clase que representa una solicitud de validar un bloque
 * @author Alejandro Lopez y Sofia Garcia
 */
public class ValidateBlockRq implements IMessage {
    private Block block;
    private MiningNode miningNode;
    /**
     * Constructor de la clase
     * @param block Bloque a validar
     * @param miningNode Nodo minero que envia la solicitud
     * @return Objeto de la clase ValidateBlockRq
     */
    public ValidateBlockRq(Block block, MiningNode miningNode) {
        this.block = block;
        this.miningNode = miningNode;
    }
    /**
     * Metodo que devuelve el bloque a validar
     * @return Bloque a validar
     */
    public Block getBlock() {
        return block;
    }
    /**
     * Metodo que devuelve el nodo minero que envia la solicitud
     * @return Nodo minero que envia la solicitud
     */
    public MiningNode getMiningNode() {
        return miningNode;
    }
    /**
     * Metodo que devuelve el mensaje de la solicitud
     * @return Mensaje de la solicitud
     */
    @Override
    public String getMessage() {
        return "ValidateBlockRq";
    }
    /**
     * Metodo que procesa la solicitud
     * @param n Nodo que procesa la solicitud
     * @return void
     */
    @Override
    public void process(Node n) {
        System.out.println(String.format(
                        "[" +
                                n.fullName() +
                                "] " +
                                "Received Task: ValidateBlockRq: <b:" +
                                block.getId() +
                                ", src:%03d" +
                                ">",
                        miningNode.getId()
                )
        );

        n.handleValidateBlockRq(this);

    }
}

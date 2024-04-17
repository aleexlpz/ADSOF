package block;
import interfaces.IMiningMethod;
import network.Transaction;
import utils.*;

import utils.CommonUtils;

/**
 * Clase que implementa el método de minado simple.
 * 
 * @author Alejandro López Martínez y Sofía García Héras
 * 
 */

public class SimpleMining implements IMiningMethod {
    /**
     * Constructor de la clase SimpleMining.
     * @param block Bloque a minar.
     */
    public SimpleMining() {
    }
    /**
     * Método que crea el hash de un bloque.
     * @param block Bloque al que se le va a crear el hash.
     * @return Hash del bloque.
     */
    @Override
    public String createHash(Block block){

        if(block.getPreviousBlock() == null) {
            return CommonUtils.sha256(block.getVersion() + BlockConfig.GENESIS_BLOCK + block.getTimestamp() + block.getDifficulty() + block.getNonce());
        }
        else
            return CommonUtils.sha256(block.getVersion() + block.getPreviousBlock().getHash() + block.getTimestamp() + block.getDifficulty() + block.getNonce());

    }
    /**
     * Método que mina un bloque.
     * @param transaction Transacción que se va a añadir al bloque.
     * @param previousBlock Bloque anterior al que se va a minar.
     * @param minerKey Clave del minero.
     * @return Bloque minado.
     */
    @Override
    public Block mineBlock(Transaction transaction, Block previousBlock, String minerKey) {

        Block block = new Block(transaction);
        block.setPreviousBlock(previousBlock);
        block.setHash(createHash(block));
        return block;
    }

}

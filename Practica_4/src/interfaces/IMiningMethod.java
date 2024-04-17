package interfaces;

import block.*;
import network.*;


/**
 * Interfaz que se encarga de todo el proceso de minado de un bloque
 * @author Alejandro Lopez y Sofia Garcia
 */
public interface IMiningMethod {
    String createHash(Block block);
    Block mineBlock(Transaction transaction, Block previousConfirmedBlock, String minerKey);
}

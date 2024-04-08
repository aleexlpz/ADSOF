package Practica_4;

public interface IMiningMethod {
    String createHash(Block block);
    Block mineBlock(Transaction transaction, Block previousConfirmedBlock, String minerKey);
}

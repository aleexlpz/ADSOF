package block;
import interfaces.IMiningMethod;
import network.Transaction;
import utils.*;

import utils.CommonUtils;

public class SimpleMining implements IMiningMethod {

    public SimpleMining() {
    }
    @Override
    public String createHash(Block block){

        if(block.getPreviousBlock() == null) {
            return CommonUtils.sha256(block.getVersion() + BlockConfig.GENESIS_BLOCK + block.getTimestamp() + block.getDifficulty() + block.getNonce());
        }
        else
            return CommonUtils.sha256(block.getVersion() + block.getPreviousBlock().getHash() + block.getTimestamp() + block.getDifficulty() + block.getNonce());

    }

    @Override
    public Block mineBlock(Transaction transaction, Block previousBlock, String minerKey) {

        Block block = new Block(transaction);
        block.setPreviousBlock(previousBlock);
        block.setHash(createHash(block));
        return block;
    }

}

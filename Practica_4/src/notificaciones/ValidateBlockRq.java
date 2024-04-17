package notificaciones;

import block.*;
import interfaces.*;
import network.*;

public class ValidateBlockRq implements IMessage {
    private Block block;
    private MiningNode miningNode;

    public ValidateBlockRq(Block block, MiningNode miningNode) {
        this.block = block;
        this.miningNode = miningNode;
    }

    public Block getBlock() {
        return block;
    }
    public MiningNode getMiningNode() {
        return miningNode;
    }
    @Override
    public String getMessage() {
        return "ValidateBlockRq";
    }

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

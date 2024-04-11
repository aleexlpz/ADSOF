package Practica_4;

import Practica_4.utils.*;

import java.util.*;

public class Block {
    private final Integer id;
    private final int version;
    private final int nonce;
    private final int timestamp;
    private final int difficulty;
    private final Transaction transaction;
    private boolean validated;
    private String hash;
    private Block previousBlock;

    private ArrayList<Block> blocks;

    private static int nextId = 0;

    public Block(Transaction transaction) {
        this.id = nextId++;
        this.version = BlockConfig.VERSION;
        this.nonce = (int) (Math.random() * 1000);
        this.timestamp = (int) (new Date().getTime() / 1000);
        this.difficulty = BlockConfig.DIFFICULTY;
        this.transaction = transaction;
        this.validated = false;
        this.hash = "";
        this.previousBlock = this.getPreviousBlock();
        this.blocks = new ArrayList<>();
        blocks.add(this);
    }

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public int getNonce() {
        return nonce;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Block getPreviousBlock() {
        for (Block block : blocks) {
            if (block.getId() == id - 1) {
                previousBlock = block;
            }
            else{
                previousBlock = null;

            }
        }
        return previousBlock;
    }

    public void setPreviousBlock(Block previousBlock) {
        this.previousBlock = previousBlock;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", difficulty=" + difficulty +
                ", transaction=" + transaction +
                ", validated=" + validated +
                ", hash='" + hash + '\'' +
                ", previousBlock=" + previousBlock +
                '}';
    }
}

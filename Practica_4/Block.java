package Practica_4;

import Practica_4.utils.*;

import java.util.*;

public class Block {
    private final int id;
    private  int version;
    private  int nonce;
    private  int timestamp;
    private  int difficulty;
    private Transaction transaction;
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

    /**
     * Getter para id del bloque
     * @return id del bloque
     */
    public int getId() {
        return id;
    }

    /**
     * Getter para version del bloque
     * @return version del bloque
     */
    public int getVersion() {
        return version;
    }

    /**
     * Getter para nonce del bloque
     * @return nonce del bloque
     */
    public int getNonce() {
        return nonce;
    }

    /**
     * Getter para timestamp del bloque
     * @return timestamp del bloque
     */
    public int getTimestamp() {
        return timestamp;
    }

    /**
     * Getter para dificultad del bloque
     * @return dificultad del bloque
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Getter para transacción del bloque
     * @return transacción del bloque
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Getter para validación del bloque
     * @return validación del bloque
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * Setter para validación del bloque
     * @param validated validación del bloque
     */
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

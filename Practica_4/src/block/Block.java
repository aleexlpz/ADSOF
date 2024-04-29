package block;

import network.*;
import utils.*;
import java.util.*;

/**
 * Clase que representa un bloque de la cadena de bloques
 * 
 * @author Alejandro López Martínez y Sofía García Héras
 *
 */

public class Block {
    private final int id;
    private int version;
    private int nonce;
    private int timestamp;
    private int difficulty;
    private network.Transaction transaction;
    private boolean validated;
    private String hash;
    private Block previousBlock;
    private String minerKey;

    private static int nextId = -1;

    /**
     * Constructor de la clase Block
     * @param transaction   transacción que se va a añadir al bloque
     */
    public Block(Transaction transaction) {
        this.id = nextId++;
        this.version = BlockConfig.VERSION;
        this.nonce = (int) (Math.random() * 1000);
        this.timestamp = (int) (new Date().getTime() / 1000);
        this.difficulty = BlockConfig.DIFFICULTY;
        this.transaction = transaction;
        this.validated = false;
        this.hash = "";
        this.previousBlock = null;
        this.minerKey = null;

    }

    /**
     * Constructor de la clase Block
     * 
     * @param transaction   transacción que se va a añadir al bloque
     * @param previousBlock bloque anterior al bloque actual
     * @param minerKey      clave del minero
     */
    public Block(Transaction transaction, Block previousBlock, String minerKey) {
        this.id = ++nextId;
        this.version = BlockConfig.VERSION;
        this.nonce = (int) (Math.random() * 1000);
        this.timestamp = (int) (new Date().getTime() / 1000);
        this.difficulty = BlockConfig.DIFFICULTY;
        this.transaction = transaction;
        this.validated = false;
        this.hash = null;
        this.previousBlock = previousBlock;
        this.minerKey = minerKey;
    }

    /**
     * Getter para id del bloque
     * 
     * @return id del bloque
     */
    public int getId() {
        return id;
    }

    /**
     * Getter para version del bloque
     * 
     * @return version del bloque
     */
    public int getVersion() {
        return version;
    }

    /**
     * Getter para nonce del bloque
     * 
     * @return nonce del bloque
     */
    public int getNonce() {
        return nonce;
    }

    /**
     * Getter para timestamp del bloque
     * 
     * @return timestamp del bloque
     */
    public int getTimestamp() {
        return timestamp;
    }

    /**
     * Getter para dificultad del bloque
     * 
     * @return dificultad del bloque
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Getter para transacción del bloque
     * 
     * @return transacción del bloque
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Getter para validación del bloque
     * 
     * @return validación del bloque
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * Setter para validación del bloque
     * 
     * @param validated validación del bloque
     */
    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    /**
     * Getter para hash del bloque
     * 
     * @return hash del bloque
     */
    public String getHash() {
        return hash;
    }

    /**
     * Setter para hash del bloque
     * 
     * @param hash hash del bloque
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Getter para bloque anterior
     * 
     * @return bloque anterior
     */
    public Block getPreviousBlock() {

        return previousBlock;
    }

    /**
     * Setter para bloque anterior
     * 
     * @param previousBlock bloque anterior
     */
    public void setPreviousBlock(Block previousBlock) {
        this.previousBlock = previousBlock;
    }

    /**
     * Getter para lista de bloques
     * 
     * @return lista de bloques
     */
    @Override
    public String toString() {
        return "id: " + this.id + ", v: " + this.version + ", nonce: " + this.nonce + ", ts: " + this.timestamp
                + ", diff: " + this.difficulty + ", hash: " + this.hash + ", minerK: " + this.minerKey;
    }
}

package network;

import exception.*;

/**
 * Clase que representa una transaccion de la red
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public class Transaction {
    private int id;
    private static int nextId = 0;
    private String senderkey;
    private String receiverkey;
    private int value;

    /**
     * Constructor de la clase Transaction
     * 
     * @param sender
     * @param receiver
     * @param value
     * @throws TransactionException
     */
    public Transaction(Wallet sender, Wallet receiver, int value) throws TransactionException {
        this(sender, receiver.getPublicKey(), value);
    }

    /**
     * Constructor de la clase Transaction
     * 
     * @param sender
     * @param receiver
     * @param value
     * @throws TransactionException
     */
    public Transaction(Wallet sender, String receiver, int value) throws TransactionException {
        if (value < 0) {
            throw new TransactionException(sender, receiver, value);
        }
        this.id = nextId++;
        this.senderkey = sender.getPublicKey();
        this.receiverkey = receiver;
        this.value = value;
    }

    /**
     * Metodo que devuelve el id de la transaccion
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que devuelve el emisor de la transaccion
     * 
     * @return emisor
     */
    public String getSender() {
        return senderkey;
    }

    /**
     * Metodo que devuelve el receptor de la transaccion
     * 
     * @return receptor
     */

    public String getReceiver() {
        return receiverkey;
    }

    /**
     * Metodo que devuelve el valor de la transaccion
     * 
     * @return valor
     */
    public int getValue() {
        return value;
    }

    /**
     * Metodo toString de la clase Transaction
     * 
     * @param value
     */
    @Override
    public String toString() {
        return "Transaction " + this.id + "| from: " + this.senderkey + ", to: " + this.receiverkey + ", quantity: "
                + this.value;
    }
}

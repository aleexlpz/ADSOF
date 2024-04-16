package Practica_4;

import Practica_4.exception.*;

public class Transaction {
    private int id;
    private static int nextId = 0;
    private String senderkey;
    private String receiverkey;
    private int value;

    

    public Transaction(Wallet sender, Wallet receiver, int value) throws TransactionException{
        this(sender, receiver.getPublicKey(), value);
    }

    public Transaction(Wallet sender, String receiver, int value) throws TransactionException{
        if (value <0){
            throw new TransactionException(sender, receiver, value);
        }
        this.id = nextId++;
        this.senderkey = sender.getPublicKey();
        this.receiverkey = receiver;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return senderkey;
    }

    public String getReceiver() {
        return receiverkey;
    }


    public int getValue() {
        return value;
    }



    @Override
    public String toString() {
        return "Transaction " + this.id + "| from: " + this.senderkey + ", to: " + this.receiverkey + ", quantity: " + this.value;
    }
}

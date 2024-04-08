package Practica_4.exception;

import Practica_4.*;

public class TransactionException extends Exception {
    private Wallet emisor;
    private String receptor;
    private int cantidad;


    public TransactionException(Wallet emisor, String receptor, int cantidad) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "source: "+this.emisor.getPublicKey() + ", receiver: "+this.receptor+", amount: "+this.cantidad;
    }
}

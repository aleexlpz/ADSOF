package Practica_4;

import Practica_4.Transaction;

public class TransactionNotification {
    private Transaction tr1;
    private Message msg;
    public TransactionNotification(Transaction tr1) {
        this.tr1 = tr1;
        this.msg = new Message("Transaction: " + tr1.getId());
    }
    public Transaction getTransaction() {
        return tr1;
    }

}

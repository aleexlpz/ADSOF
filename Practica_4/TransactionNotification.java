package Practica_4;


public class TransactionNotification implements IMessage {
    private Transaction tr1;
    public TransactionNotification(Transaction tr1) {
        this.tr1 = tr1;
    }
    public Transaction getTransaction() {
        return tr1;
    }

    @Override
    public String getMessage() {
        return this.tr1.toString();
    }
    public void process(Node n) {
        IMessage.super.process(n);
        n.addTransaction(tr1);
    }

}

package Practica_4;

public class TransactionNotification implements IMessage {
    private Transaction tr1;
    /**
        * Constructor de la clase
        * 
        * @param tr1 transaccion
        */
    public TransactionNotification(Transaction tr1) {
        this.tr1 = tr1;
    }

   

    /**
     * Devuelve la mensaje
     * 
     * @return Devuelve el mensaje
     */
    @Override
    public String getMessage() {
        return this.tr1.toString();
    }

    /**
     * Procesar con el nodo anyadiendo la transaccion
     * 
     * @param el nodo que sa va a procesar
     */
    @Override
    public void process(Node n) {
        IMessage.super.process(n);
        n.addTransaction(tr1);
    }

    /**
     * Devuelve la transaccion
     * 
     * @return Devuelve la transaccion
     */
    public Transaction getTransaction() {
        return tr1;
    }

    /**
     * Devuelve el mensaje
     * 
     * @return Devuelve el mensaje
     */
    @Override
    public String toString() {
        return "TransactionNotification{" +
                "tr1=" + tr1 +
                '}';
    }

}

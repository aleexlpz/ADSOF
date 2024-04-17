package notificaciones;

import interfaces.*;
import network.*;

public class TransactionNotification implements IMessage {
    private Transaction tr1;

    /**
     * Constructor de la clase
     * 
     * @param tr1 Transaction
     */
    public TransactionNotification(Transaction tr1) {
        this.tr1 = tr1;
    }

    /**
     * metodo para obtener la transaccion
     * 
     * @return Transaction
     */
    public Transaction getTransaction() {
        return tr1;
    }

    /**
     * metodo para obtener el mensaje
     * 
     * @return String
     */
    @Override
    public String getMessage() {
        return this.tr1.toString();
    }

    /**
     * metodo para procesar la notificacion
     * 
     * @param n Nodo que recibe la notificacion
     * @return void
     */
    public void process(Node n) {
        System.out.println(
                "[" +
                        n.fullName() +
                        "]" +
                        " - Received notification - Nex Tx: " +
                        this.getMessage());

        n.handleTransactionNotification(this);

    }

}
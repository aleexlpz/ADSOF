package exception;

import network.*;

/**
 * TransactionException
 * 
 * @author Alejandro López Martínez y Sofía García Héras
 * 
 */
/**
 * Clase que representa una excepción de transaccion
 * @author Alejandro Lopez y Sofia Garcia
 */
public class TransactionException extends RuntimeException {
    private Wallet emisor;
    private String receptor;
    private int cantidad;

    /**
     * Constructor de la excepción
     * @param emisor Wallet que intenta enviar la transacción
     * @param receptor Wallet que recibe la transacción
     * @param cantidad Cantidad de monedas a enviar
     * @return Excepción de transacción
     */
    public TransactionException(Wallet emisor, String receptor, int cantidad) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.cantidad = cantidad;
    }
    /**
     * Método que devuelve el mensaje de la excepción
     * @return Mensaje de la excepción
     */
    @Override
    public String toString() {
        return "Negative transfer attempt: source: "+this.emisor.getPublicKey() + ", receiver: "+this.receptor+", amount: "+this.cantidad;
    }
}

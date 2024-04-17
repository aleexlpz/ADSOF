package exception;
import network.*;

/**
 * DuplicateConnectionException
 * 
 * @author Alejandro López Martínez y Sofía García Héras
 * 
 */

public class DuplicateConnectionException extends RuntimeException{
    private Node nodo;

    /**
     * Constructor de la excepción
     * @param n Nodo que ha generado la excepción
     * @return Excepción de conexión duplicada
     */
    public DuplicateConnectionException(Node n) {

        this.nodo = n;

    }

    /**
     * Método que devuelve el mensaje de la excepción
     * @return Mensaje de la excepción
     */
    @Override
    public String toString() {
        return " Connection exception: Node "+ String.format("%03d", this.nodo.getId())+" is connected to a different network";
    }
}

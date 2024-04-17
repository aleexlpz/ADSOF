package exception;


import network.*;

/**
 * ConnectionException
 *
 * @author Alejandro López Martínez y Sofía García Heras
 * 
 */
public class ConnectionException extends RuntimeException{
    private Node nodo;

    public ConnectionException(Node n) {
    /**
     * Constructor de la excepción
     * @param n Nodo que ha lanzado la excepción
     * @return ConnectionException
     */
        this.nodo = n;

    }
    
    /**
     * Devuelve el mensaje de error
     * @return String
     */
    
    @Override
    public String toString() {
        return "Connection exception: Node "+ String.format("%03d", this.nodo.getId())+" is already connected to the network";
    }
}

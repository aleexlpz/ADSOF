package exception;


import network.*;

public class ConnectionException extends RuntimeException{
    private Node nodo;

    public ConnectionException(Node n) {

        this.nodo = n;

    }
    @Override
    public String toString() {
        return "Connection exception: Node "+ String.format("%03d", this.nodo.getId())+" is already connected to the network";
    }
}

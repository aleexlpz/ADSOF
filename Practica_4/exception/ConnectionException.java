package Practica_4.exception;


import Practica_4.Node;

public class ConnectionException extends RuntimeException{
    private Node nodo;

    public ConnectionException(Node n) {

        this.nodo = n;

    }
    @Override
    public String toString() {
        return "Connection exception: Node "+this.nodo.getId()+" is already connected to the network";
    }
}

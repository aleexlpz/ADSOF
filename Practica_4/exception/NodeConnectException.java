package Practica_4.exception;

import Practica_4.*;
public abstract class NodeConnectException extends Exception{
    private Node nodo;
    public NodeConnectException(Node n) {
        this.nodo = n;
    }

    @Override
    public String toString() {
        return "Connection exception: Node " + this.nodo.getId();
    }
}

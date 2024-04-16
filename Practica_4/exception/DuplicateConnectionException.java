package Practica_4.exception;
import Practica_4.*;
public class DuplicateConnectionException extends RuntimeException{
    private Node nodo;

    public DuplicateConnectionException(Node n) {

        this.nodo = n;

    }
    @Override
    public String toString() {
        return " Connection exception: Node "+ String.format("%03d", this.nodo.getId())+" is connected to a different network";
    }
}

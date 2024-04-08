package Practica_4.exception;
import Practica_4.*;
public class DuplicateConnectionException extends NodeConnectException{
    public DuplicateConnectionException(Node n) {
        super(n);
    }

    @Override
    public String toString() {
        return super.toString() + " is already connected to the network";
    }
}

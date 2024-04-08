package Practica_4.exception;


import Practica_4.Node;

public class ConnectionException extends NodeConnectException{
    public ConnectionException(Node n) {
        super(n);
    }
    @Override
    public String toString() {
        return super.toString()+ " is connected to a different network";
    }
}

package Practica_4.exception;


public class ConnectionException extends Exception{
    public ConnectionException(String message) {
        super(message);
    }


    @Override
    public String toString() {
        return "Connection exception: "+super.toString() + " is connected to a different network";
    }
}

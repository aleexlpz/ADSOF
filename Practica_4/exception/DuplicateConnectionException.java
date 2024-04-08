package Practica_4.exception;

public class DuplicateConnectionException extends ConnectionException{
    public DuplicateConnectionException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Connection exception: " +super.toString() + " is already connected to the network";
    }
}

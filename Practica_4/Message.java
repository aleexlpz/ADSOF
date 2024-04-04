package Practica_4;

public class Message implements IMessage{
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

    @Override
    public void process(Node n) {
        System.out.println("["+n.fullName()+"]"+
                " - Received notification - Nex Tx: "+
                this.getMessage());
    }
}

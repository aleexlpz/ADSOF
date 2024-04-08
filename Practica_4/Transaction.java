package Practica_4;

public class Transaction {
    private int id;
    private static int nextId = 1;
    private Wallet sender;
    private Wallet receiver;
    private int value;

    public Transaction(Wallet sender, Wallet receiver, int value) {
        this.id = nextId++;
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Wallet getSender() {
        return sender;
    }


    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", senderKey='" + this.sender.getKey() + '\'' +
                ", receiverKey='" + this.receiver.getKey() + '\'' +
                ", value=" + this.value +
                '}';
    }
}

package Practica_4;

public class Transaction {
    private int id;
    private static int nextId = 1;
    private String senderKey;
    private String receiverKey;
    private int value;

    public Transaction(Wallet sender, Wallet receiver, int value) {
        this.id = nextId++;
        this.senderKey = senderKey;
        this.receiverKey = receiverKey;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getSenderKey() {
        return senderKey;
    }

    public String getReceiverKey() {
        return receiverKey;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", senderKey='" + senderKey + '\'' +
                ", receiverKey='" + receiverKey + '\'' +
                ", value=" + value +
                '}';
    }
}

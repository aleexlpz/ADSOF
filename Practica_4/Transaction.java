package Practica_4;
//Transaction: los Wallets pueden llevar a cabo transacciones entre ellos. Cada transacción tiene un identificador único e incluye la
//clave del emisor, la clave del receptor y el valor de la transacción.
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

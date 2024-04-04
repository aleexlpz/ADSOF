package Practica_4;
import java.util.*;


public class Node implements IConnectable{
    private int id;
    private static int nextId = 0;
    private Wallet wallet;
    private int mips;
    private List<Transaction> transactions;
    private IConnectable parent;


    /**
     * Constructor for the Node class
     * @param wallet the wallet of the node
     */
    public Node(Wallet wallet) {
        this.id = nextId++;
        this.wallet = wallet;
        this.transactions = new ArrayList<>();
    }
    /**
     * Metodo para enviar un mensaje
     * @param wallet the wallet of the node
     */
    public void broadcast(IMessage msg) {
        System.out.println("ADSOF blockchain - new message broadcasted: " + msg);
    }
    /**
     * Metodo para recibir un padre
     * @return the parent of the node
     */
    public IConnectable getParent() {
        return parent;
    }
    /**
     * Metodo para recibir el padre superior
     * @param parent the parent of the node
     */
    public IConnectable getTopParent() {
        IConnectable parent = getParent();
        while (parent!=null) {
            if (parent.getParent()==null) return parent;
            parent = parent.getParent();
        }
        return parent;
    }
    /**
     * Metodo para recibir el id
     * @return id id
     *      */
    public int getId() {
        return id;
    }
    /**
     * Metodo para recibir el waller
     * @return wallet 
     */
    public Wallet getWallet() {
        return wallet;
    }
    /**
     * Metodo para recibir el mips
     * @return mips
     */
    public int getMips() {
        return mips;
    }
    /**
     * Metodo para recibir las transacciones
     * @return List<Transaction> transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
    /**
     * Metodo para añadir una transaccion
     * @param t the transaction to add
     */
    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }

    /**
     * Metodo para crear una transaccion
     * @param receiver the receiver of the transaction
     * @param value the value of the transaction
     * @return Transaction t
     */
    public Transaction createTransaction(Wallet receiver, int value){
        Transaction t = new Transaction(this.wallet, receiver, value);
        if(this.transactions.contains(t)){
            throw new IllegalArgumentException("Transaction already exists");
        }
        this.transactions.add(t);
        return t;
    }
    /**
     * Metodo para imprimir el nombre completo
     * @return String
     */
    public String fullName(){
        return "@Node#" + String.format("%03d", this.getId());
    }

    @Override
    public String toString() {
        return this.wallet + " | @Node#" + String.format("%03d", this.getId());
    }
}

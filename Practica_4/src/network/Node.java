package network;

import java.util.*;

import notificaciones.*;
import exception.*;
import interfaces.*;
import block.*;

/**
 * Clase que representa un nodo de la red
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public class Node extends Element {

    private Wallet wallet;
    private List<Transaction> transactions;

    /**
     * Constructor de la clase Node
     * 
     * @param wallet
     */
    public Node(Wallet wallet) {
        this.wallet = wallet;
        this.transactions = new ArrayList<Transaction>();
        this.parent = null;
    }

    /**
     * Metodo que devuelve la cartera del nodo
     * 
     * @return Wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * Metodo que devuelve las transacciones del nodo
     * 
     * @return List<Transaction>
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Metodo que devuelve las transacciones confirmadas del nodo
     * 
     * @param t Transaccion a añadir
     */
    public void addTransaction(Transaction t) {
        this.transactions.add(t);
    }

    /**
     * Metodo que devuelve si es un nodo
     * 
     * @return true si es un nodo, false si no
     */
    @Override
    public boolean isNode() {
        return true;
    }

    /**
     * Metodo que devuelve si es una subred
     * @return true si es una subred, false si no
     * 
     */
    @Override
    public boolean isSubnet() {
        return false;
    }
    /**
     * Metodo que devuelve el nodo
     * @return Node
     */
    @Override
    public Node getNode() {
        return this;
    }

    /**
     * Metodo que crea una transaccion
     * 
     * @return Transaction
     * @param receiver receptor de la transaccion
     * @param value    valor de la transaccion
     * @throws TransactionException
     */
    public Transaction createTransaction(Wallet receiver, int value) throws TransactionException {

        if (this.wallet.getBalance() < value) {
            throw new TransactionException(this.wallet, receiver.getPublicKey(), value);
        }

        Transaction t = new Transaction(this.wallet, receiver, value);
        return t;
    }

    /**
     * Metodo que crea una transaccion
     * 
     * @param receiver receptor de la transaccion
     * @param value    valor de la transaccion
     * @return Transaction
     * @throws TransactionException
     */
    public Transaction createTransaction(String receiver, int value) throws TransactionException {
        if (this.wallet.getBalance() < value) {
            throw new TransactionException(wallet, receiver, value);
        }
        Transaction t = new Transaction(this.wallet, receiver, value);
        return t;
    }

    /**
     * Metodo que comprueba si un nodo esta incluido en la red
     * 
     * @param n nodo
     * @return true si esta incluido, false si no
     * @throws ConnectionException
     */
    @Override
    public boolean nodoIncluido(Node n) throws ConnectionException {
        if (this == n) {
            throw new ConnectionException(n);
        }
        return false;
    }

    /**
     * Metodo que devuelve el nombre completo del nodo
     * 
     * @return String
     */
    public String fullName() {
        return "@Node#" + String.format("%03d", this.getId());
    }
    /* METODOS DE LA INTERFAZ ICONNECTABLE */

    @Override
    public void broadcast(IMessage msg) {
        msg.process(this);
    }

    /**
     * Metodo que maneja una notificacion de transaccion
     * 
     * @param t
     */
    public void handleTransactionNotification(TransactionNotification tnot) {
    }

    /**
     * Metodo que se encarga de manejar la validacion de bloque request
     * 
     * @param validateblockrq
     */
    public void handleValidateBlockRq(ValidateBlockRq validateblockrq) {
    }

    public void handleValidateBlockRes(ValidateBlockRes validateblockres) {
        Block block = validateblockres.getBlock();
        Transaction transaction = block.getTransaction();
        boolean bool = false;

        System.out.println("[" + this.fullName() + "] Commiting transaction: Tx-" + transaction.getId() + " in "
                + this.fullName());
        System.out.println("[" + this.fullName() + "] -> Tx details: " + transaction.toString());

        this.addTransaction(transaction);

        if (wallet.getPublicKey() == transaction.getSender()) {
            wallet.setBalance(wallet.getBalance() - transaction.getValue());
            bool = true;
        } else if (wallet.getPublicKey() == transaction.getReceiver()) {
            wallet.setBalance(wallet.getBalance() + transaction.getValue());
            bool = true;
        }
        if (bool) {
            System.out.println("[" + this.fullName() + "] Applied Transaction: " + transaction.toString());

            System.out.println("[" + this.fullName() + "] New wallet value: " + wallet.toString());
        }

    }

    /**
     * Metodo toString de la clase Node
     */
    @Override
    public String toString() {
        return this.wallet + " | @Node#" + String.format("%03d", this.getId());
    }
}

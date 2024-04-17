package network;
import java.util.*;

import notificaciones.*;
import exception.*;
import interfaces.*;
/**
 * Clase que representa un nodo de la red
 * @author Alejandro Lopez y Sofia Garcia
 */
public class Node extends Element{

    private Wallet wallet;
    private List<Transaction> transactions;

    /**
     * Constructor de la clase Node
     * @param wallet
     */
    public Node(Wallet wallet) {
        this.wallet = wallet;
        this.transactions = new ArrayList<>();
    }

    /**
     * Metodo que devuelve la cartera del nodo
     * @return Wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * Metodo que devuelve las transacciones del nodo
     * @return List<Transaction>
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
    /**
     * Metodo que devuelve las transacciones confirmadas del nodo
     * @param t Transaccion a añadir
     */
    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }

    /**
     * Metodo que crea una transaccion
     * @return Transaction
     * @param receiver receptor de la transaccion
     * @param value valor de la transaccion
     * @throws TransactionException
     */
    public Transaction createTransaction(Wallet receiver, int value) throws TransactionException{

        if (this.wallet.getBalance() < value){
            throw new TransactionException(this.wallet,receiver.getPublicKey(), value);
        }

        Transaction t = new Transaction(this.wallet, receiver, value);
        this.transactions.add(t);
        return t;
    }
    /**
     * Metodo que crea una transaccion
     * @param receiver receptor de la transaccion
     * @param value valor de la transaccion
     * @return Transaction
     * @throws TransactionException
     */
    public Transaction createTransaction(String receiver, int value) throws TransactionException{

        Transaction t = new Transaction(this.wallet, receiver, value);
        this.transactions.add(t);
        return t;
    }
    /**
     * Metodo que maneja una notificacion de transaccion
     * @param t
     */
    public void handleTransactionNotification(TransactionNotification tnot){}
    /**
     * Metodo que comprueba si un nodo esta incluido en la red
     * @param n nodo
     * @return true si esta incluido, false si no
     * @throws ConnectionException
     */
    @Override
    public boolean nodoIncluido(Node n) throws ConnectionException{
        if (this == n) {
            throw new ConnectionException(n);
        }
        return false;
    }
    /**
     * Metodo que devuelve el nombre completo del nodo
     * @return String
     */
    public String fullName(){
        return "@Node#" + String.format("%03d", this.getId());
    }
    /*METODOS DE LA INTERFAZ ICONNECTABLE */

    @Override
    public IConnectable getParent() {
        return null;
    }

    @Override
    public void broadcast(IMessage msg) {
        msg.process(this);
    }
    /**
     * Metodo que se encarga de manejar la validacion de bloque request
     * @param validateblockrq
     */
    public void handleValidateBlockRq(ValidateBlockRq validateblockrq) {}


    public void handleValidateBlockRes(ValidateBlockRes validateblockres) {}

    /**
     * Metodo toString de la clase Node
     */
    @Override
    public String toString() {
        return this.wallet + " | @Node#"+ String.format("%03d", this.getId());
    }
}

package Practica_4;
import java.util.*;

import Practica_4.exception.*;

public class Node extends Element{

    private Wallet wallet;
    private boolean isMiner;
    private int mips;
    private List<Transaction> transactions;


    public Node(Wallet wallet) {
        this.wallet = wallet;
        this.isMiner = false;
        this.transactions = new ArrayList<>();
    }


    public Wallet getWallet() {
        return wallet;
    }

    public boolean isMiner() {
        return isMiner;
    }

    public int getMips() {
        return mips;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }


    public Transaction createTransaction(Wallet receiver, int value) throws TransactionException{

        if (this.wallet.getBalance() < value){
            throw new TransactionException(this.wallet,receiver.getKey(), value);
        }

        Transaction t = new Transaction(this.wallet, receiver, value);
        this.transactions.add(t);
        return t;
    }
    public Transaction createTransaction(String receiver, int value) throws TransactionException{

        Transaction t = new Transaction(this.wallet, receiver, value);
        this.transactions.add(t);
        return t;
    }
    @Override
    public boolean nodoIncluido(Node n)throws DuplicateConnectionException{
        if (this == n) {
            throw new DuplicateConnectionException(n);
        }
        return false;
    }


    public String fullName(){
        return "@Node#" + this.getId();
    }


    @Override
    public IConnectable getParent() {
        return null;
    }

    @Override
    public void broadcast(IMessage msg) {
        msg.process(this);
    }

    @Override
    public String toString() {
        return this.wallet + " | @Node#"+ this.getId();
    }
}

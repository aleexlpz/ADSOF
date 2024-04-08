package Practica_4;
import java.util.*;

import Practica_4.exception.*;

public class Node implements IConnectable{
    private int id;
    private static int nextId = 0;
    private Wallet wallet;
    private boolean isMiner;
    private int mips;
    private List<Transaction> transactions;



    public Node(Wallet wallet) {
        this.id = nextId++;
        this.wallet = wallet;
        this.isMiner = false;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
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


    public String fullName(){
        return "@Node#" + String.format("%03d", this.getId());
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
        return this.wallet + " | @Node#" + String.format("%03d", this.getId());
    }
}

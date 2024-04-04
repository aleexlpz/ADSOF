package Practica_4;
import java.util.*;

//Node: es el elemento básico para el funcionamiento del Blockchain. Cada nodo tiene un identificador único en la red, un Wallet
//asociado y una lista de transacciones (con el objetivo de conocer cuales están confirmadas). Hay dos tipos de nodos: simples y
//minadores. Los nodos simples están enfocados únicamente a hacer transacciones, mientras que los nodos minadores, además de
//proporcionar la misma funcionalidad que los nodos simples, son capaces de minar y validar bloques (lo veremos en apartados
//posteriores), por lo que definen una capacidad computacional medida en MIPS.
public class Node {
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


    public Transaction createTransaction(Wallet receiver, int value){
        Transaction t = new Transaction(this.wallet, receiver, value);
        this.transactions.add(t);
        return t;
    }

    public String fullName(){
        return "@Node#" + String.format("%03d", this.getId());
    }

    @Override
    public String toString() {
        return this.wallet + " | @Node#" + String.format("%03d", this.getId());
    }
}

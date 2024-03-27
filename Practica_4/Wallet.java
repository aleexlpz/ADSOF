package Practica_4;


import blockchain.utils.CommonUtils;

public class Wallet {
    private String username;
    private String key;
    private int balance;


    public Wallet(String username, String key, int balance) {
        this.username = username;
        this.key = key;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "u: " + username + ", PK:" + key + ", balance: " + balance;
    }
}

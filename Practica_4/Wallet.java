package Practica_4;


public class Wallet {
    private String username;
    private String key;
    private int balance;

    /**
     * Constructor de la clase Wallet
     * @param username Nombre del usuario
     * @param key Clave pública del usuario
     * @param balance Saldo del usuario
     */
    public Wallet(String username, String key, int balance) {
        this.username = username;
        this.key = key;
        this.balance = balance;
    }
    /**
     * Metodo que devuelve el nombre del usuario
     * @param username Nombre del usuario
     */
    public String getUsername() {
        return username;
    }
    /**
     * Metodo que devuelve la clave pública del usuario
     * @param key Clave pública del usuario
     */
    public String getKey() {
        return key;
    }
    /**
     * Metodo que devuelve el saldo del usuario
     * @param balance Saldo del usuario
     */
    public int getBalance() {
        return balance;
    }
    /**
     * Metodo que establece el saldo del usuario
     * @param balance Saldo del usuario
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    /**
     * Metodo que devuelve la clave pública del usuario
     */
    public Wallet getPublicKey() {
        return this;
    }

    @Override
    public String toString() {
        return "u: " + username + ", PK:" + key + ", balance: " + balance;
    }
}

package Practica_4;

public class MiningNode extends Node{
    private int cComputacional;

    public MiningNode(Wallet wallet, int cComputacional) {
        super(wallet);
        this.cComputacional = cComputacional;
    }

    public int getcComputacional() {
        return cComputacional;
    }

    @Override
    public String toString() {
        return this.getWallet() + " | @MiningNode#" + String.format("%03d", this.getId());
    }

}

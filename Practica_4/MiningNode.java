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

    public String fullName() {
        return "@MiningNode#" + this.getId();
    }

    public void setMiningMethod(IMiningMethod miningMethod) {

    }

    @Override
    public String toString() {
        return this.getWallet() + " | @MiningNode#" +  this.getId();
    }

}

package Practica_4;
import java.util.*;
//BlockchainNetwork: representa la red de comunicaciones del entorno Blockchain. Tiene un nombre y está compuesta por una lista
//de nodos y subredes (Subnet). Una subred tiene un identificador único, está compuesta de nodos, y su constructor debe soportar la
//creación de subredes de distintos tamaños, es decir, debe poder recibir distinto número de nodos como parámetro.
public class BlockchainNetwork {
    private String name;
    private List<Node> nodes;
    private List<Subnet> subnets;

    public BlockchainNetwork(String name) {
        this.name = name;
        this.nodes = new ArrayList<>();
        this.subnets = new ArrayList<>();
    }
    public BlockchainNetwork connect(Object element) throws ConnectionException {
        if(element instanceof Node){
            if(this.nodes.contains((Node) element)){
                throw new ConnectionException(((Node) element).fullName() + "is already connected to the network");
            }
            for (Subnet s : this.subnets){
                if(s.getNodes().contains((Node) element)){
                    throw new ConnectionException(((Node) element).fullName() + "is connected to a different network");
                }
            }
            System.out.println("ADSOF blockchain - new peer connected: " + element);
            this.nodes.add((Node) element);
        }else if(element instanceof Subnet){
            System.out.println("ADSOF blockchain - new peer connected: " + element);
            this.subnets.add((Subnet) element);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Subnet> getSubnets() {
        return subnets;
    }

    public void brodcast(TransactionNotification tn){
        for(Node n : this.nodes){
            tn.process(n);
        }
        for(Subnet s : this.subnets){
            s.brodcast(tn);
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" consists of ").append(this.nodes.size() + this.subnets.size()).append(" elements:\n");
        for(Node n : this.nodes){
            sb.append("* ").append(n).append("\n");
        }
        for(Subnet s : this.subnets){
            sb.append("* ").append(s).append("\n");
        }
        return sb.toString();
    }

}

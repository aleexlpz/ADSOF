package Practica_4;
import java.util.*;
import exceptions.*;

//BlockchainNetwork: representa la red de comunicaciones del entorno Blockchain. Tiene un nombre y está compuesta por una lista
//de nodos y subredes (Subnet). Una subred tiene un identificador único, está compuesta de nodos, y su constructor debe soportar la
//creación de subredes de distintos tamaños, es decir, debe poder recibir distinto número de nodos como parámetro.
public class BlockchainNetwork implements IConnectable{
    private String name;
    private List<Node> nodes;
    private List<Subnet> subnets;
    /**
     * Constructor for BlockchainNetwork
     * @param name the name of the network
     */
    public BlockchainNetwork(String name) {
        this.name = name;
        this.nodes = new ArrayList<>();
        this.subnets = new ArrayList<>();
    }

    /**
     * Connects a new element to the network
     * @param element the element to connect
     * @return the network
     */
    public BlockchainNetwork connect(Object element) throws ConnectionException, DuplicateConnectionException {
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


    public IConnectable getParent() {
        return null;
    }

    public void broadcast(IMessage message) {
        System.out.println("ADSOF blockchain - message broadcasted: " + message);
        for(Node n : this.nodes){
            n.broadcast(message);
        }
        for(Subnet s : this.subnets){
            s.broadcast(message);
        }
        
    }
    
    public IConnectable getTopParent() {
        IConnectable parent = getParent();
        while (parent!=null) {
            if (parent.getParent()==null) return parent;
            parent = parent.getParent();
        }
        return parent;
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

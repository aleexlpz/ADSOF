package Practica_4;

import Practica_4.exception.*;
import Practica_4.utils.*;

import java.util.*;

public class BlockchainNetwork implements IConnectable{
    private String name;
    private List<Node> nodes;
    private List<Subnet> subnets;

    public BlockchainNetwork(String name) {
        this.name = name;
        this.nodes = new ArrayList<>();
        this.subnets = new ArrayList<>();
    }

    public BlockchainNetwork connect(Node node) throws ConnectionException {
        if(this.nodes.contains(node)){
            throw new ConnectionException(node.fullName() + "  is already connected to the network");
        }
        System.out.println("ADSOF blockchain - new peer connected: " + node);
        this.nodes.add(node);
        return this;
    }
    public BlockchainNetwork connect(Subnet subnet) throws DuplicateConnectionException {
        for (Node n : subnet.getNodes()){
            if(this.nodes.contains(n)){
                throw new DuplicateConnectionException(n.fullName() + "is connected to a different network");
            }
        }
        System.out.println("ADSOF blockchain - new peer connected: " + subnet);
        this.subnets.add(subnet);
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

    @Override
    public IConnectable getParent() {
        return null;
    }

    @Override
    public void broadcast(IMessage msg){
        for(Node n : this.nodes){
            n.broadcast(msg);
        }
        for(Subnet s : this.subnets){
            s.broadcast(msg);
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

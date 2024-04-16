package Practica_4;
import java.util.*;

import Practica_4.exception.*;

public class Subnet extends Element{

    private List<Node>  nodes;

    public Subnet(Node... nodes) {
        this.nodes = Arrays.asList(nodes);

    }
    @Override
    public boolean nodoIncluido(Node n) throws DuplicateConnectionException{
        for (Node node: this.nodes){
            if (node == n) {
                throw new DuplicateConnectionException(node);
            }
        }
        return false;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public IConnectable getParent() {
        return null;
    }

    @Override
    public void broadcast(IMessage msg) {
        System.out.println("[Subnet#"+String.format("%03d", this.getId())+"] "+msg.getMessage());
        System.out.println("Broadcasting to "+this.nodes.size()+" nodes:");
        for (Node nodo: this.nodes) {
            nodo.broadcast(msg);
        }
    }


    @Override
    public String toString() {
        String s= "Node network of " + nodes.size() + " nodes: " ;
        for (Node node: this.nodes) {
            s += " ["+node.toString()+"]";
        }
        return s;
    }
}

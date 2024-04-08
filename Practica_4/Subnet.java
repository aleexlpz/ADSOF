package Practica_4;
import java.util.*;

public class Subnet implements IConnectable{
    private int id;
    private static int nextId = 1;
    private List<Node>  nodes;

    public Subnet(Node... nodes) {
        this.id = nextId++;
        this.nodes = Arrays.asList(nodes);

    }

    public int getId() {
        return id;
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
        System.out.println("[Subnet#"+this.getId()+"] "+msg.getMessage());
        System.out.println("Broadcasting to "+this.nodes.size()+" nodes:");
        for (Node nodo: this.nodes) {
            nodo.broadcast(msg);
        }
    }



    @Override
    public String toString() {
        return "Node network of " + nodes.size() + " nodes: " + nodes;
    }
}

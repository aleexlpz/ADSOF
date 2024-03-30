package Practica_4;
import java.util.*;

public class Subnet {
    private int id;
    private static int nextId = 1;
    private List<Node>  nodes;

    public Subnet(Node... nodes) {
        this.id = nextId++;
        this.nodes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Node> getNodes() {
        return nodes;
    }


    @Override
    public String toString() {
        return "Node network of " + nodes.size() + " nodes: " + nodes;
    }
}

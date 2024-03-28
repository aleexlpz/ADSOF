package Practica_4;
import java.util.*;

public class Subnet extends Element {
    private int id;
    private static int nextId = 1;
    private Node[] nodes;

    public Subnet(Node... nodes) {
        this.id = nextId++;
        this.nodes = nodes;
    }

    public int getId() {
        return id;
    }

    public Node[] getNodes() {
        return nodes;
    }


    @Override
    public String toString() {
        return "Node network of " + nodes.length + " nodes: " + Arrays.toString(nodes);
    }
}

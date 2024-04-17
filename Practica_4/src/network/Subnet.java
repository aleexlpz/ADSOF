package network;
import java.util.*;

import exception.*;
import interfaces.*;
/**
 * Clase que representa una subred de nodos
 * @author Alejandro Lopez y Sofia Garcia
 */
public class Subnet extends Element {

    private List<Node>  nodes;
    /**
     * Constructor de la clase Subnet
     * @param nodes
     */
    public Subnet(Node... nodes) {
        this.nodes = Arrays.asList(nodes);

    }
    /**
     * Metodo que devuelve los nodos de la subred
     * @return List<Node>
     */
    public List<Node> getNodes() {
        return nodes;
    }
    /**
     * Metodo que comprueba si un nodo esta incluido en la subred
     * @param n Nodo a comprobar
     * @return true si esta incluido, false si no
     * @throws DuplicateConnectionException
     */
    @Override
    public boolean nodoIncluido(Node n) throws DuplicateConnectionException{
        for (Node node: this.nodes){
            if (node == n) {
                throw new DuplicateConnectionException(node);
            }
        }
        return false;
    }
    /*METODOS DE LA INTERFAZ ICONNECTABLE */
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

    /**
     * Metodo toString de la clase Subnet
     */
    @Override
    public String toString() {
        String s= "Node network of " + nodes.size() + " nodes: " ;
        for (Node node: this.nodes) {
            s += " ["+node.toString()+"]";
        }
        return s;
    }
}

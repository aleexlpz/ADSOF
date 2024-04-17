package network;

import java.util.*;

import exception.*;
import interfaces.*;

/**
 * Clase que representa una subred de nodos
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public class Subnet extends Element {

    private ArrayList<Node> nodes;

    /**
     * Constructor de la clase Subnet
     * 
     * @param nodes
     */
    public Subnet(Node... nod) {
        this.nodes = new ArrayList<Node>();

        for (Node node : nod) {
            node.setParent(this);
            this.nodes.add(node);
        }

        this.parent = null;
    }

    /**
     * Metodo que devuelve los nodos de la subred
     * 
     * @return List<Node>
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Metodo que devuelve si es un nodo
     * 
     */
    @Override
    public boolean isNode() {
        return false;
    }

    /**
     * Metodo que devuelve si es una subred
     * 
     */
    @Override

    public boolean isSubnet() {
        return true;
    }
    /**
     * Metodo que devuelve la subred
     * @return Subnet
     */
    @Override
    public Subnet getSubnet() {
        return this;
    }

    /**
     * Metodo que comprueba si un nodo esta incluido en la subred
     * 
     * @param n Nodo a comprobar
     * @return true si esta incluido, false si no
     * @throws DuplicateConnectionException
     */
    @Override
    public boolean nodoIncluido(Node n) throws DuplicateConnectionException {
        for (Node node : this.nodes) {
            if (node == n) {
                throw new DuplicateConnectionException(node);
            }
        }
        return false;
    }

    /* METODOS DE LA INTERFAZ ICONNECTABLE */
    /**
     * Metodo que conecta un nodo a la subred
     * 
     * @param n Nodo a conectar
     * @return void
     */
    @Override
    public void broadcast(IMessage msg) {
        System.out.println("[Subnet#" + String.format("%03d", this.getId()) + "] " + msg.getMessage());
        System.out.println("Broadcasting to " + this.nodes.size() + " nodes:");
        for (Node nodo : this.nodes) {
            nodo.broadcast(msg);
        }
    }

    /**
     * Metodo toString de la clase Subnet
     * 
     * @return String
     */
    @Override
    public String toString() {
        String s = "Node network of " + nodes.size() + " nodes: ";
        for (Node node : this.nodes) {
            s += " [" + node.toString() + "]";
        }
        return s;
    }
}

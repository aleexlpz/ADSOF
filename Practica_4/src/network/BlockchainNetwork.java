package network;

import exception.*;
import interfaces.*;

import java.util.*;

/**
 * Clase que representa una red de blockchain
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public class BlockchainNetwork implements IConnectable {
    private String name;
    private List<Element> elementos;

    /**
     * Constructor de la clase BlockchainNetwork
     * 
     * @param name
     */
    public BlockchainNetwork(String name) {
        this.name = name;
        this.elementos = new ArrayList<Element>();
    }

    /**
     * Metodo que conecta un nodo a la red
     * 
     * @param node
     * @return BlockchainNetwork
     * @throws ConnectionException
     * @throws DuplicateConnectionException
     */
    public BlockchainNetwork connect(Element e) throws ConnectionException, DuplicateConnectionException {
        System.out.print(this.name + " - new peer connected: ");

        if (e.isNode()) {
            Node node = e.getNode();
            this.nodoIncluido(node);
            node.setParent(this);
            System.out.println(node.toString());

        }
        if (e.isSubnet()) {
            Subnet subnet = e.getSubnet();
            subnet.setParent(this);
            System.out.println(subnet.toString());
        }
        this.elementos.add(e);
        return this;

    }

    /**
     * Metodo que comprueba si un nodo esta incluido en la red
     * 
     * @param node
     * @return BlockchainNetwork
     * @throws ConnectionException
     */
    public boolean nodoIncluido(Node nodo) throws ConnectionException, DuplicateConnectionException {
        for (Element element : this.elementos) {
            element.nodoIncluido(nodo);
        }
        return false;
    }

    /**
     * Metodo getter que devuelve el nombre de la red
     * 
     * @return nombre de la red
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo getter que devuelve los elementos de la red
     * 
     * @return elementos de la red
     */
    public List<Element> getElementos() {
        return this.elementos;
    }

    /* FUNCIONES DE LA INTERFAZ ICONNECTABLE */
    /**
     * Metodo que devuelve el padre de la red
     * 
     * @return null
     */
    @Override
    public IConnectable getParent() {
        return null;
    }

    /**
     * Metodo que se encarga de procesar el mensaje
     * 
     * @param msg mensaje a procesar
     */
    @Override
    public void broadcast(IMessage msg) {
        for (Element elem : this.elementos) {
            elem.broadcast(msg);
        }
    }

    /**
     * Metodo toString de la clase BlockchainNetwork
     * 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" consists of ").append(this.elementos.size()).append(" elements:\n");
        for (Element e : this.elementos) {
            sb.append("* ").append(e).append("\n");
        }
        return sb.toString();
    }

}

package network;

import exception.*;
import interfaces.*;

/**
 * Clase abstracta que representa los elementos de la red
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public abstract class Element implements IConnectable {
    private final int id;
    private static int nextId = 0;
    protected IConnectable parent;

    /**
     * Constructor de la clase Element
     */
    public Element() {
        this.id = nextId++;
        this.parent = null;
    }

    /**
     * Metodo que devuelve el id del elemento
     * 
     * @return id del elemento
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que establece el padre del elemento
     * 
     * @param parent Padre del elemento
     */
    public void setParent(IConnectable parent) {
        this.parent = parent;
    }

    /**
     * Metodo abstracto que comprueba si un nodo esta incluido en la red
     * 
     * @param n Nodo a comprobar
     * @return true si esta incluido, false si no
     * @throws ConnectionException exception de conexion
     * @throws DuplicateConnectionException exception de conexion duplicada
     */
    public abstract boolean nodoIncluido(Node n) throws ConnectionException, DuplicateConnectionException;

    /**
     * Metodo abstracto que comprueba si es un nodo
     * 
     * @return true si es un nodo, false si no
     */
    public abstract boolean isNode();

    /**
     * Metodo abstracto que comprueba si es una subred
     * 
     * @return true si es una subred, false si no
     */
    public abstract boolean isSubnet();

    /**
     * Metodo que devuelve el nodo
     * 
     * @return Nodo
     */
    public Node getNode() {
        return null;
    }

    /**
     * Metodo que devuelve la subred
     * 
     * @return Subred
     */
    public Subnet getSubnet() {
        return null;
    }

    /* FUNCIONES DE LA INTERFAZ ICONNECTABLE */
    /**
     * Metodo que devuelve el padre del elemento
     * 
     * @return Padre del elemento
     */
    public IConnectable getParent() {
        return this.parent;
    }
}

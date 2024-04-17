package network;

import exception.*;
import interfaces.IConnectable;
/**
 * Clase abstracta que representa los elementos de la red
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
    }
    /**
     * Metodo que devuelve el id del elemento
     * @return id del elemento
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo que establece el padre del elemento
     * @param parent Padre del elemento
     */
    public void setParent(IConnectable parent) {
        this.parent = parent;
    }

    /**
     * Metodo abstracto que comprueba si un nodo esta incluido en la red
     * @param n Nodo a comprobar
     * @return boolean
     * @throws ConnectionException
     * @throws DuplicateConnectionException
     */
    public abstract boolean nodoIncluido(Node n)throws ConnectionException, DuplicateConnectionException;

    /* FUNCIONES DE LA INTERFAZ ICONNECTABLE */
    public IConnectable getParent() {
        return this.parent;
    }
    
}

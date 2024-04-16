package Practica_4;

import Practica_4.exception.*;

public abstract class Element implements IConnectable{
    private final int id;
    private static int nextId = 0;

    protected IConnectable parent;


    public Element() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public abstract boolean nodoIncluido(Node n)throws ConnectionException, DuplicateConnectionException;

    public void setParent(IConnectable parent) {
        this.parent = parent;
    }
    public IConnectable getParent() {
        return this.parent;
    }
}

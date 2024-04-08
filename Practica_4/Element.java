package Practica_4;

import Practica_4.exception.*;

public abstract class Element implements IConnectable{
    private final String id;
    private static int nextId = 0;


    public Element() {
        this.id = String.format("%03d", nextId);
        nextId++;
    }

    public String getId() {
        return id;
    }

    public abstract boolean nodoIncluido(Node n)throws ConnectionException, DuplicateConnectionException;



}

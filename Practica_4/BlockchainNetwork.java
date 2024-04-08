package Practica_4;

import Practica_4.exception.*;
import Practica_4.utils.*;

import java.util.*;

public class BlockchainNetwork implements IConnectable{
    private String name;
    private List<Element> elementos;

    public BlockchainNetwork(String name) {
        this.name = name;
        this.elementos= new ArrayList<>();
    }

    public BlockchainNetwork connect(Node node) throws ConnectionException, DuplicateConnectionException {
        this.nodoIncluido(node);
        this.elementos.add(node);
        System.out.println("ADSOF blockchain - new peer connected: " + node);
        return this;
    }
    public BlockchainNetwork connect(Subnet subnet) {
        if (this.elementos.contains(subnet)) {
            return null;
        }
        this.elementos.add(subnet);

        System.out.println("ADSOF blockchain - new peer connected: " + subnet);
        return this;
    }

    public boolean nodoIncluido(Node nodo) throws ConnectionException, DuplicateConnectionException {
        for (Element element: this.elementos) {
            element.nodoIncluido(nodo);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Element> getElementos() {
        return this.elementos;
    }


    @Override
    public IConnectable getParent() {
        return null;
    }

    @Override
    public void broadcast(IMessage msg){
        for(Element elem: this.elementos){
            elem.broadcast(msg);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" consists of ").append(this.elementos.size()).append(" elements:\n");
        for(Element e: this.elementos){
            sb.append("* ").append(e).append("\n");
        }
        return sb.toString();
    }

}

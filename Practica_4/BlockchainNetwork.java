package Practica_4;
import java.util.*;
//BlockchainNetwork: representa la red de comunicaciones del entorno Blockchain. Tiene un nombre y está compuesta por una lista
//de nodos y subredes (Subnet). Una subred tiene un identificador único, está compuesta de nodos, y su constructor debe soportar la
//creación de subredes de distintos tamaños, es decir, debe poder recibir distinto número de nodos como parámetro.
public class BlockchainNetwork {
    private String name;
    private List<Element> elements;

    public BlockchainNetwork(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }
    public void connect(Element element){
        this.elements.add(element);
    }
    public String getName() {
        return name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Subnet> getSubnets() {
        return subnets;
    }


    @Override
    public String toString() {
        return this.name+ " - ";
    }

}

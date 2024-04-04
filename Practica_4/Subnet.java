package Practica_4;
import java.util.*;

import exceptions.*;

/*Para soportar subredes (Subnet) dentro de redes (BlockchainNetwork), el método getParent devolverá
el objeto IConnectable padre si lo hay, o null en caso contrario. El método default getTopParent devuelve el objeto IConnectable de
nivel superior, y puede serte útil en apartados posteriores.*/
public class Subnet extends BlockchainNetwork{
    private List<Node> nodes;
    private IConnectable parent;

    public Subnet(String name) {
        super(name);
        this.nodes = new ArrayList<>();
        this.parent = null;
    }

    public List<Node> getNodes() {
        return nodes;
    }
    public IConnectable getParent(){
        return this.parent;
    }
    public IConnectable getTopParent(){
        if(this.parent == null){
            return this;
        }
        return this.parent.getTopParent();
    }


    public Subnet connect(Node node) throws ConnectionException {
        if(this.nodes.contains(node)){
            throw new ConnectionException(node.fullName() + "is already connected to the network");
        }
        for (Subnet s : this.getSubnets()){
            if(s.getNodes().contains(node)){
                throw new ConnectionException(node.fullName() + "is connected to a different network");
            }
        }
        System.out.println("ADSOF blockchain - new peer connected: " + node);
        this.nodes.add(node);
        return this;
    }


    @Override
    public String toString() {
        return "Node network of " + nodes.size() + " nodes: " + nodes;
    }
}

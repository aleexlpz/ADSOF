package interfaces;

/**
 * Interfaz que se encarga de enviar y recibir mensajes entre los nodos de la
 * red.
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public interface IConnectable {
    public void broadcast(IMessage msg);

    public IConnectable getParent();

    public default IConnectable getTopParent() {
        IConnectable parent = getParent();
        while (parent != null) {
            if (parent.getParent() == null)
                return parent;
            parent = parent.getParent();
        }
        return parent;
    }
}
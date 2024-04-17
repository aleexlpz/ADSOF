package interfaces;

import network.Node;

/**
 * Interfaz que se encarga de mandar mensajes
 * @author Alejandro Lopez y Sofia Garcia
 */
public interface IMessage {
public String getMessage();
public default void process(Node n) {
System.out.println("["+n.fullName()+"]"+
" - Received notification - Nex Tx: "+
this.getMessage());
}
}

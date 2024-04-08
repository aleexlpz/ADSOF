package Practica_4;

public interface IMessage {
public String getMessage();
public default void process(Node n) {
System.out.println("["+n.fullName()+"]"+
" - Received notification - Nex Tx: "+
this.getMessage());
}
}

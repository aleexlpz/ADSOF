package Practica_4;

public class Connectable extends Element implements IConnectable{
    private IConnectable parent;

    public Connectable(IConnectable parent) {
        this.parent = parent;
    }

    @Override
    public void broadcast(IMessage msg) {
        IConnectable topParent = this.getTopParent();
        if (topParent!=null) {
            topParent.broadcast(msg);
        }
    }
    @Override
    public IConnectable getParent() {
        return parent;
    }
    public IConnectable getTopParent() {
        IConnectable parent = getParent();
        while (parent!=null) {
            if (parent.getParent()==null) return parent;
            parent = parent.getParent();
        }
        return parent;
    }
}

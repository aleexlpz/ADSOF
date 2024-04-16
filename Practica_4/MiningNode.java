package Practica_4;
public class MiningNode extends Node{
    private int cComputacional;
    private SimpleMining miningMethod;
    private SimpleValidate validateMethod;


    public MiningNode(Wallet wallet, int cComputacional) {
        super(wallet);
        this.cComputacional = cComputacional;
        this.miningMethod = null;
        this.validateMethod = null;
    }

    public String fullName() {
        return "@MiningNode#" + String.format("%03d", this.getId());
    }


    public int getcComputacional() {
        return this.cComputacional;
    }
    public void setcComputacional(int cComputacional) {
        this.cComputacional = cComputacional;
    }
    public SimpleMining getMiningMethod() {
        return this.miningMethod;
    }
    public SimpleValidate getValidationMethod() {
        return this.validateMethod;
    }
    public void setMiningMethod(SimpleMining simpleMining) {
        this.miningMethod = simpleMining;
    }
    public void setValidationMethod(SimpleValidate simpleValidate) {
        this.validateMethod = simpleValidate;
    }

    public void handleValidateBlockRq(ValidateBlockRq validateblockrq) {
        //Si el nodo no es el que envió el mensaje, debe extraer el bloque del mensaje y utilizar el método validate para
        //obtener el resultado de la validación del bloque
        IConnectable network = this.getTopParent();

        if (this != validateblockrq.getMiningNode()) {
            Block block = validateblockrq.getBlock();
            boolean res = this.validateMethod.validate(miningMethod, block);
            ValidateBlockRes validateBlockRes = new ValidateBlockRes(block, res, this.getId());
            System.out.println(
                    String.format(
                            "[" +
                                    this.fullName() +
                                    "] " +
                                    "Emitted Task: ValidateBlockRes: <b:" +
                                    block.getId() +
                                    ", src:%03d" +
                                    ">",
                            validateblockrq.getMiningNode().getId()
                    )
            );
            network.broadcast(validateBlockRes);
        }
        else{
            System.out.println("["+this.fullName()+"] You cannot validate your own block");
        }
    }

    @Override
    public String toString() {
        return this.getWallet() + " | @MiningNode#" +  String.format("%03d", this.getId());
    }

}

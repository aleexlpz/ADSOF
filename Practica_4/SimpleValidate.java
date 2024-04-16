package Practica_4;

public class SimpleValidate implements IValidateMethod{

    @Override
    public boolean validate(IMiningMethod miningMethod, Block block) {
        return miningMethod.createHash(block).equals(block.getHash());
    }
}

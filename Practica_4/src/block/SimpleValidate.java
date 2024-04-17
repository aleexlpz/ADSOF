package block;

import interfaces.IMiningMethod;
import interfaces.IValidateMethod;

public class SimpleValidate implements IValidateMethod {

    @Override
    public boolean validate(IMiningMethod miningMethod, Block block) {
        return miningMethod.createHash(block).equals(block.getHash());
    }
}

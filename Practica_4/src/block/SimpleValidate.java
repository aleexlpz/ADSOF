package block;

import interfaces.*;

/**
 * clase que implementa la interfaz IValidateMethod
 * 
 * @author Alejandro López Martínez y Sofía García Héras
 * 
 */

public class SimpleValidate implements IValidateMethod {

    /**
     * Método que valida si el hash del bloque es correcto
     * 
     * @param miningMethod método de minado
     * @param block        bloque a validar
     * @return true si el hash del bloque es correcto, false en caso contrario
     */
    @Override
    public boolean validate(IMiningMethod miningMethod, Block block) {
        return miningMethod.createHash(block).equals(block.getHash());
    }
}

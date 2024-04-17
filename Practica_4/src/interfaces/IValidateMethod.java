package interfaces;

import block.*;

/**
 * Interfaz que se encarga del proceso de validacion de un bloque
 * 
 * @author Alejandro Lopez y Sofia Garcia
 */
public interface IValidateMethod {
    public boolean validate(IMiningMethod miningMethod, Block block);
}

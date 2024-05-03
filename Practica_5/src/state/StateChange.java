package state;

import java.time.*;
/**
 * Clase StateChange que representa un cambio de estado
 * @author Alejandro López Martínez y Sofía García
 */
public class StateChange <S extends Comparable<S>> {
    private final S oldState;
    private final S newState;
    private final LocalDateTime time;
    /**
     * Constructor de la clase StateChange
     * @param oldState Estado anterior
     * @param newState Nuevo estado
     */
    public StateChange(S oldState, S newState) {
        this.oldState = oldState;
        this.newState = newState;
        this.time = LocalDateTime.now();
    }
    /**
     * Método que devuelve el estado anterior
     * @return Estado anterior
     */
    public S getOldState() {
        return this.oldState;
    }
    /**
     * Método que devuelve el nuevo estado
     * @return Nuevo estado
     */
    public S getNewState() {
        return this.newState;
    }
   
    @Override
    public String toString() {
        if (this.oldState == null) {
            return "(in: "+this.newState+" at: "+this.time+")";
        }
        else {
            return "(from: "+this.oldState+" to "+this.newState+" at: "+this.time+")";
        }
    }
}

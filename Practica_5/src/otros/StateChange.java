package Practica_5.src.otros;

import java.time.*;

public class StateChange <S extends Comparable<S>> {
    private final S oldState;
    private final S newState;
    private final LocalDateTime time;

    public StateChange(S oldState, S newState) {
        this.oldState = oldState;
        this.newState = newState;
        this.time = LocalDateTime.now();
    }

    public S getOldState() {
        return this.oldState;
    }

    public S getNewState() {
        return this.newState;
    }

    public String toString() {
        if (this.oldState == null) {
            return "(in: "+this.newState+" at: "+this.time+")";
        }
        else {
            return "(from: "+this.oldState+" to: "+this.newState+" at: "+this.time+")";
        }
    }
}

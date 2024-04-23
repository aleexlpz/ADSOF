package otros;

public class ObjectStateTracker<T, S extends Enum<S>> {
    private S currentState;
    private S[] states;
    private T[] objects;
    private boolean[] objectStates;
    private boolean[] stateStates;
    private boolean[] stateObjects;
    private boolean[] stateObjectStates;
    
    public ObjectStateTracker(S[] states) {
        this.states = states;
        this.currentState = states[0];
    }
    
   /*  public ObjectStateTracker<T, S> withState(S state, StatePredicate<T> predicate) {
        return this;
    } */
    
    public ObjectStateTracker<T, S> elseState(S state) {
        return this;
    }
    
    public void addObjects(T... objects) {
        this.objects = objects;
    }

    public void addStates(S... states) {
        this.states = states;
    }
    
    public void updateStates() {
    }
    
    public String toString() {
        return "";
    }
}
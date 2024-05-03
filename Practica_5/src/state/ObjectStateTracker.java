package state;

import java.util.*;
import java.util.function.Predicate;

public class ObjectStateTracker<T, S extends Enum<S>> implements Iterable<T>, StateIterable {
    private final Map<S, List<T>> stateMap = new LinkedHashMap<>();
    private final Set<S> validStates = new LinkedHashSet<>();
    private final Map<Predicate<T>, S> conditions = new HashMap<>();
    private final Map<T, S> elementStates = new HashMap<>();
    private final Map<T, List<StateChange<S>>> trajectories = new HashMap<>();
    private S defaultState = null;

    public ObjectStateTracker(S[] states) {
        validStates.addAll(Arrays.asList(states));
        for (S state : validStates) {
            stateMap.put(state, new ArrayList<>());
        }
    }

    public ObjectStateTracker<T, S> withState(S state, Predicate<T> predicate) {
        checkState(state);
        conditions.put(predicate, state);
        return this;
    }

    public void elseState(S state) {
        checkState(state);
        defaultState = state;
    }

    public void updateStates() {
        for (T element : elementStates.keySet()) {
            updateStates(element);
        }
    }

    private void updateStates(T element) {
        S currentState = this.elementStates.get(element);
        for (Map.Entry<Predicate<T>, S> entry : this.conditions.entrySet()) {
            if (entry.getKey().test(element)) {
                S newState = entry.getValue();
                if (currentState != newState) {
                    updateTrajectory(element, currentState, newState);
                }
                return;
            }
        }
        if (currentState != this.defaultState) {
            updateTrajectory(element, currentState, this.defaultState);
        }
    }

    private void updateTrajectory(T element, S oldState, S newState) {
        this.trajectories.get(element).add(new StateChange<>(oldState, newState));
        if (oldState != null) {
            this.stateMap.get(oldState).remove(element);
        }
        this.stateMap.get(newState).add(element);
        this.elementStates.put(element, newState);
    }

    private void checkState(S state) {
        if (!validStates.contains(state)) {
            throw new IllegalStateException("Invalid state: " + state);
        }
    }

    public final void addObjects(T... objects) {
        for (T object : objects) {
             if (!this.elementStates.containsKey(object)) {
                this.elementStates.put(object, null);
                this.trajectories.put(object, new ArrayList<>());
                this.updateStates(object);
            } 
        }
       
    }

    public List<StateChange<S>> trajectory(T object) {
        return this.trajectories.get(object);
    }

    @Override
    public Iterator<T> iterator() {
        return this.elementStates.keySet().iterator();
    }

    @Override
    public String toString() {
        return this.stateMap.toString();
    }


}
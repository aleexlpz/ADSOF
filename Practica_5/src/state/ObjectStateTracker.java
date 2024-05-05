package state;

import java.util.*;
import java.util.function.Predicate;

/**
 * 
 * Clase generica que representa un rastreador de estados de objetos
 * 
 * @autor Alejandro López Martínez y Sofía García Héras
 */
public class ObjectStateTracker<T, S extends Enum<S>> implements Iterable<T>, StateIterable {
    private final Map<S, List<T>> stateObjectMap  = new LinkedHashMap<>();
    private final Set<S> validStatesSet = new LinkedHashSet<>();
    private final Map<Predicate<T>, S> stateConditions  = new HashMap<>();
    private final Map<T, S> elementStateMap = new HashMap<>();
    private final Map<T, List<StateChange<S>>> objectTrajectories  = new HashMap<>();
    private S defaultState = null;

    /**
     * Constructor de la clase ObjectStateTracker
     * 
     * @param states Estados
     */
    public ObjectStateTracker(S[] states) {
        validStatesSet.addAll(Arrays.asList(states));
        for (S state : validStatesSet) {
            stateObjectMap .put(state, new ArrayList<>());
        }
    }

    /**
     * Método que añade un estado a un objeto si se cumple una condición
     * 
     * @param state  Estado
     * @param predicate predicado
     */
    public ObjectStateTracker<T, S> withState(S state, Predicate<T> predicate) {
        checkState(state);
        stateConditions.put(predicate, state);
        return this;
    }

    /**
     * Método indica el estado del objeto si ninguna de las condiciones anteriores
     * se cumple
     ** @param state  Estado
     */
    public void elseState(S state) {
        checkState(state);
        defaultState = state;
    }

    /**
     * Método que comprueba el estado
     * @param state Estado
     */
    private void checkState(S state) {
        if (!validStatesSet.contains(state)) {
            throw new IllegalStateException("Invalid state: " + state);
        }
    }

    /**
     * Método que actualiza los estados
     */
    public void updateStates() {
        for (T element : elementStateMap.keySet()) {
            updateStates(element);
        }
    }

    /**
     * Método que actualiza los estados de un objeto
     * 
     * @param element Objeto
     */
    private void updateStates(T element) {
        S currentState = this.elementStateMap.get(element);
        for (Map.Entry<Predicate<T>, S> entry : this.stateConditions.entrySet()) {
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

    /**
     * Método que actualiza la trayectoria de un objeto
     * 
     * @param element  Objeto
     * @param oldState Estado actual
     * @param newState Nuevo estado
     */
    private void updateTrajectory(T element, S oldState, S newState) {
        this.objectTrajectories.get(element).add(new StateChange<>(oldState, newState));
        if (oldState != null) {
            this.stateObjectMap.get(oldState).remove(element);
        }
        this.stateObjectMap .get(newState).add(element);
        this.elementStateMap.put(element, newState);
    }

    public final void addObjects(T... objects) {
        for (T object : objects) {
            if (!this.elementStateMap.containsKey(object)) {
                this.elementStateMap.put(object, null);
                this.objectTrajectories.put(object, new ArrayList<>());
                this.updateStates(object);
            }
        }

    }
    /**
     * Metodo que devolverá la trayectoria del objeto
     * @param object Objeto
     * @return Trayectoria del objeto
     */
    public List<StateChange<S>> trajectory(T object) {
        return this.objectTrajectories.get(object);
    }

    @Override
    public Iterator<T> iterator() {
        return this.elementStateMap.keySet().iterator();
    }

    @Override
    public String toString() {
        return this.stateObjectMap.toString();
    }

}
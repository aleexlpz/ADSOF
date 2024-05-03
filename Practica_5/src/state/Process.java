package state;

import java.util.*;

public class Process<S extends Comparable<S>> {
    private final Map<S, List<S>> stateTransitions = new LinkedHashMap<>();
    private final Map<S, Integer> initialStatesFrequency = new HashMap<>();
    private final Map<S, Integer> finalStatesFrequency = new HashMap<>();

    public Process(S[] states) {        
        initializeStates(states);
    }

    private void initializeStates(S[] states) {
        for (S state : states) {
            this.stateTransitions.put(state, new ArrayList<>());
            this.initialStatesFrequency.put(state, 0);
            this.finalStatesFrequency.put(state, 0);
        }
    }

    public void add(List<StateChange<S>> trajectory) {
        S previousState = null;
        S newState = null;
        for (StateChange<S> stateChange : trajectory) {
            previousState = stateChange.getOldState();
            newState = stateChange.getNewState();
            
            updateInitialAndFinalStates(previousState, newState);
            addStateChange(previousState, newState);
        }
        this.finalStatesFrequency.put(newState, this.finalStatesFrequency.get(newState) + 1);
    }
    private void updateInitialAndFinalStates(S previousState, S newState) {
        if (previousState == null) {
            this.initialStatesFrequency.put(newState, this.initialStatesFrequency.get(newState) + 1);
        }
         
    }

    private void addStateChange(S previousState, S newState) {
        if (previousState != null) {
            stateTransitions.get(previousState).add(newState);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (S state : stateTransitions.keySet()) {
            sb.append(state)
                    .append(" (initial ")
                    .append(initialStatesFrequency.get(state))
                    .append(" times, final ")
                    .append(finalStatesFrequency.get(state))
                    .append(" times):\n");

            Map<S, Integer> nextStateCounts = countNextStates(stateTransitions.get(state));
            appendNextStateCounts(sb, nextStateCounts);
        }
        return sb.toString();
    }

    private Map<S, Integer> countNextStates(List<S> nextStateList) {
        Map<S, Integer> nextStateCounts = new HashMap<>();
        for (S nextState : nextStateList) {
            nextStateCounts.put(nextState, nextStateCounts.getOrDefault(nextState, 0) + 1);
        }
        return nextStateCounts;
    }

    private void appendNextStateCounts(StringBuilder sb, Map<S, Integer> nextStateCounts) {
        for (Map.Entry<S, Integer> entry : nextStateCounts.entrySet()) {
            sb.append(" to state ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(" times\n");
        }
    }
}
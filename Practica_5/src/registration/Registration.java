package registration;

import state.*;
import java.util.*;

public class Registration {

    private final String name;
    private String affiliation;
    private final RegistrationKind kind;
    private double amountPayed;
    private boolean validated;

    private static final List<StateIterable> observers = new ArrayList<>();

    public Registration(String name, RegistrationKind kind) {
        this.name = name;
        this.kind = kind;
    }

   

    public double getAmountPayed() {
        return amountPayed;
    }

    public double getTotalAmount() {
        return kind.getPrice();
    }

    public String getAffiliation() {
        return affiliation;
    }

    public boolean getValidated() {
        return validated;
    }

    public void pay(double amount) {
        this.amountPayed += amount;
        notificationObservers();
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
        notificationObservers();

    }

    public void setValidated(boolean validated) {
        this.validated = validated;
        notificationObservers();
    }

    public static void withTracker(StateIterable observer) {
        observers.add(observer);

    }

    private static void notificationObservers() {
        for (StateIterable observer : observers) {
            observer.updateStates();
        }
    }

    @Override
    public String toString() {
        return "Reg. of: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registration)) return false;
        Registration that = (Registration) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}

    
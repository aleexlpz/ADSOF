package Practica_5.src.otros;

import java.util.*;

public class Registration {
    private final String name;
    private String affiliation;
    private final RegistrationKind kind;
    private double amountPayed;
    private boolean validated;

    private static final List<StateObserver> observers = new ArrayList<>();

    public Registration(String name, RegistrationKind kind) {
        this.name = name;
        this.kind = kind;
    }

    public void pay(double amount) {
        amountPayed += amount;
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

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public boolean getValidated() {
        return validated;
    }

    public static void withTracker(StateObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return "Reg. of: " + name;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
package registration;

import state.*;
import java.util.*;
/**
 * Clase Registration
 * 
 * @author Alejandro López Martínez y Sofía García Héras
 *
 */
public class Registration {

    private final String name;
    private String affiliation;
    private final RegistrationKind kind;
    private double amountPayed;
    private boolean validated;

    private static final List<StateIterable> observers = new ArrayList<>();

    /**
     * Constructor de la clase Registration
     * @param name Nombre del registro
     * @param kind Tipo de registro
     */
    public Registration(String name, RegistrationKind kind) {
        this.name = name;
        this.kind = kind;
    }

    /**
     * Método que devuelve la cantidad pagada del registro
     * @return Cantidad pagada
     */
    public double getAmountPayed() {
        return amountPayed;
    }
    /**
     * Método que devuelve el precio total del registro
     * @return Precio total
     */
    public double getTotalAmount() {
        return kind.getPrice();
    }
    /**
     * Método que devuelve el nombre del registro
     * @return Nombre del registro
     */
    public String getAffiliation() {
        return affiliation;
    }
    /**
     * Método que devuelve los estados validados 
     * @return Estados validados
     */
    public boolean getValidated() {
        return validated;
    }
    /**
     * Metodo que paga el registro
     * @param amount Cantidad a pagar
     */
    public void pay(double amount) {
        this.amountPayed += amount;
        notificationObservers();
    }
    /**
     * Método que establece la afiliacion
     * @param affiliation Estado de afiliacion
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
        notificationObservers();

    }
    /**
     * Método que establece el estado de validación 
     * @param validated Estado de validación
     */
    public void setValidated(boolean validated) {
        this.validated = validated;
        notificationObservers();
    }
    /**
     * Método que permite registrar objetos monitorizadores
     * @param observer Objeto monitorizador
     */
    public static void withTracker(StateIterable observer) {
        observers.add(observer);
    }
    /**
     * Método que notifica a los objetos monitorizadores
     */
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

    
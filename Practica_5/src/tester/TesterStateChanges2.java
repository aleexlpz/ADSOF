package tester;

import state.*;
import registration.*;
import static registration.RegistrationKind.*;
import static registration.RegistrationState.*;

public class TesterStateChanges2 {
    protected ObjectStateTracker<Registration, RegistrationState> regState;
    protected Registration meryLopez, pedroCasas, juanPerez;

    public static void main(String[] args) {
        TesterStateChanges2 tester = new TesterStateChanges2();

        // Verificar estado inicial
        tester.createRegistrations();
        System.out.println("Estado inicial:");
        System.out.println(tester.regState);

        // Realizar cambios de estado
        tester.changeRegistrations();

        // Verificar estado después de los cambios
        System.out.println("Estado después de los cambios:");
        System.out.println(tester.regState);
    }

    protected void createRegistrations() {
        this.regState = new ObjectStateTracker<>(RegistrationState.values());
        regState.withState(PAYED, r -> r.getAmountPayed() == r.getTotalAmount() && !r.getValidated())
                .withState(STARTED, r -> r.getAffiliation() == null && !r.getValidated())
                .withState(FILLED, r -> r.getAffiliation() != null && !r.getValidated())
                .withState(VALIDATED, r -> r.getAmountPayed() == 0 && r.getValidated())
                .withState(FINISHED, r -> r.getAmountPayed() == r.getTotalAmount() && r.getValidated())
                .elseState(REJECTED);

        this.meryLopez = new Registration("Maria Lopez", FULL);
        this.pedroCasas = new Registration("Pedro Casas", STUDENT);
        this.juanPerez = new Registration("Juan Perez", MEMBER);

        this.regState.addObjects(meryLopez, pedroCasas, juanPerez);

    }

    protected void changeRegistrations() {

        this.meryLopez.setAffiliation("Springfield University");
        this.pedroCasas.pay(RegistrationKind.STUDENT.getPrice());
        this.regState.updateStates();
    }
}


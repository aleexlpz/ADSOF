package Practica_5.src.tester;

import Practica_5.src.otros.*;

import static Practica_5.src.otros.RegistrationKind.*;
import static Practica_5.src.otros.RegistrationState.PAYED;
import static Practica_5.src.otros.RegistrationState.STARTED;
import static Practica_5.src.otros.RegistrationState.FILLED;
import static Practica_5.src.otros.RegistrationState.VALIDATED;
import static Practica_5.src.otros.RegistrationState.FINISHED;
import static Practica_5.src.otros.RegistrationState.REJECTED;



public class TesterStateChanges {
    protected ObjectStateTracker<Registration, RegistrationState> regState;
    protected Registration annSmith, johnDoe, lisaMartin;
    public static void main(String[] args) {
        TesterStateChanges tsc = new TesterStateChanges();
        tsc.createRegistrations();
        System.out.println(tsc.regState);
        tsc.changeRegistrations();
        System.out.println(tsc.regState);
    }
    protected void changeRegistrations() {
        this.annSmith.setAffiliation("University of Miskatonic"); // now it is filled
        this.johnDoe.pay(STUDENT.getPrice()); // becomes payed
        this.regState.updateStates();
    }
    protected void createRegistrations() {
        this.regState = new ObjectStateTracker<>(RegistrationState.values());
        regState.withState(PAYED, r -> r.getAmountPayed()==r.getTotalAmount() && !r.getValidated())
                .withState(STARTED, r -> r.getAffiliation()==null && !r.getValidated())
                .withState(FILLED, r -> r.getAffiliation()!=null && !r.getValidated())
                .withState(VALIDATED, r -> r.getAmountPayed()==0 && r.getValidated())
                .withState(FINISHED, r -> r.getAmountPayed()==r.getTotalAmount() && r.getValidated())
                .elseState(REJECTED);
        this.annSmith = new Registration("Ann Smith", FULL);
        this.johnDoe = new Registration("John Doe", STUDENT);
        this.lisaMartin = new Registration("Lisa Martin", MEMBER);
        this.regState.addObjects(annSmith, johnDoe, lisaMartin);
    }
}

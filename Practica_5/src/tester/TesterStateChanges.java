package tester;

import otros.*;

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
        this.johnDoe.pay(RegistrationKind.STUDENT.getPrice()); // becomes payed
        this.regState.updateStates();
    }

    protected void createRegistrations() {
        this.regState = new ObjectStateTracker<>(RegistrationState.values());
        regState.withState(RegistrationState.PAYED, r -> r.getAmountPayed() == r.getTotalAmount() && !r.getValidated())
                .withState(RegistrationState.STARTED, r -> r.getAffiliation() == null && !r.getValidated())
                .withState(RegistrationState.FILLED, r -> r.getAffiliation() != null && !r.getValidated())
                .withState(RegistrationState.VALIDATED, r -> r.getAmountPayed() == 0 && r.getValidated())
                .withState(RegistrationState.FINISHED, r -> r.getAmountPayed() == r.getTotalAmount() && r.getValidated())
                .elseState(RegistrationState.REJECTED);
        this.annSmith = new Registration("Ann Smith", RegistrationKind.FULL);
        this.johnDoe = new Registration("John Doe", RegistrationKind.STUDENT);
        this.lisaMartin = new Registration("Lisa Martin", RegistrationKind.MEMBER);
        this.regState.addObjects(annSmith, johnDoe, lisaMartin);
    }
}
/*STUDENT cannot be resolved. I have the class in which student is defined in the package otros. The problem is that this package is not in the same folder as the tests, everything is in a parent directory (src) and there is src/otros and src/tester */
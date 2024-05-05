package tester;

import registration.*;
import static registration.RegistrationKind.*;

public class TesterRepeatedObjects2 extends TesterStateChanges2{
    public static void main(String[] args) {
        TesterRepeatedObjects2 tsc = new TesterRepeatedObjects2();
        tsc.createRegistrations();
        tsc.regState.addObjects(new Registration("Maria Lopez", FULL)); // Discarded, since repeated
        System.out.println(tsc.regState);
    }
}

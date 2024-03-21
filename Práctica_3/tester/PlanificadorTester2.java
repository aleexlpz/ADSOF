package Práctica_3.tester;
import java.util.*;
import Práctica_3.elemcomida.*;
import Práctica_3.enums.*;
import Práctica_3.funcionalidades.*;

public class PlanificadorTester2 extends PlatosTester2 {
    public static void main(String[] args) {
        PlanificadorTester2 tester = new PlanificadorTester2();
        List<Plato> platos = new ArrayList<>(tester.crearPlatos().values());

        PlanificadorMenu planificador1 = new PlanificadorMenu(platos)
                .conMaximo(ElementoNutricional.GRASA_SATURADA, 20.0)
                .conMaximo(ElementoNutricional.AZUCARES, 15.0)
                .sinAlergenos(Alergeno.GLUTEN, Alergeno.HUEVO);
        Menu menu1 = planificador1.planificar(1000, 3000);
        System.out.println("* " + menu1);

        PlanificadorMenu planificador2 = new PlanificadorMenu(platos)
                .conMaximo(ElementoNutricional.GRASA_SATURADA, 20.0)
                .conMaximo(ElementoNutricional.AZUCARES, 15.0)
                .sinAlergenos(Alergeno.FRUTOS_SECOS);
        Menu menu2 = planificador2.planificar(800, 2500);
        System.out.println("* " + menu2);
    }
}


package Práctica_3.tester;
import java.util.*;
import Práctica_3.elemcomida.*;

public class PlatosTester2 extends IngredientesTester2 {
    public static void main(String[] args) {
        PlatosTester2 tester = new PlatosTester2();
        for (Plato plato : tester.crearPlatos().values())
            System.out.println("* " + plato);
    }

    public Map<String, Plato> crearPlatos() {
        Map<String, Ingrediente> ing = this.crearIngredientes();
        Plato p1, p2, p3;
        p1 = new Plato("Arroz con pollo");
        p1.addIngrediente(ing.get("Arroz"), 130) ;
        p1.addIngrediente(ing.get("Pollo"), 120) ;

        p2 = new Plato("Ensalada");
        p2.addIngrediente(ing.get("Lechuga"), 2);
        p2.addIngrediente(ing.get("Manzana"), 1);
        p2.addIngrediente(ing.get("Queso"), 10);
        p3 = new Plato("Sopa");
        p3.addIngrediente(ing.get("Caldo"), 80);
        p3.addIngrediente(ing.get("Garbanzos"), 40);
        return Map.of("Arroz con pollo", p1, "Ensalada", p2, "Sopa", p3);
    }
}


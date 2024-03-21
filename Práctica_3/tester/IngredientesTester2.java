package Práctica_3.tester;
import Práctica_3.elemcomida.*;
import Práctica_3.enums.*;
import Práctica_3.nutricion.*;
import java.util.*;

public class IngredientesTester2 {
    public static void main(String args[]) {
        IngredientesTester2 tester = new IngredientesTester2();
        for (Ingrediente ingrediente : tester.crearIngredientes().values())
            System.out.println("* " + ingrediente);
    }


    public Map<String, Ingrediente> crearIngredientes() {
        Map<String, Ingrediente> ingredientes = new LinkedHashMap<>();
        ingredientes.put("Arroz", new Ingrediente("Arroz", TipoIngrediente.CEREAL,
                new InfoNutricionalPeso(130, 28.2, 2.4, 0.5, 0.6, 2.3, 1.4, 0.1)));
        ingredientes.put("Lechuga", new Ingrediente("Lechuga", TipoIngrediente.FRUTA_VERDURA,
                new InfoNutricionalPeso(15, 0.0, 0.4, 0, 1.4, 0.7, 1.3, 1.2)));
        ingredientes.put("Pollo", new Ingrediente("Pollo", TipoIngrediente.CARNE,
                new InfoNutricionalPeso(165, 0, 7.4, 0.8, 25, 0, 2, 0.1)));
        ingredientes.put("Zanahoria", new Ingrediente("Zanahoria", TipoIngrediente.FRUTA_VERDURA,
                new InfoNutricionalPeso(41, 7.6, 0.9, 0.3, 2.8, 0, 3.3, 2.2)));
        ingredientes.put("Queso", new Ingrediente("Queso", TipoIngrediente.LACTEO,
                new InfoNutricionalPeso(402, 2.2, 33, 23, 1.3, 0, 0, 1.5))
                .tieneAlergenos(Alergeno.LACTOSA));
        ingredientes.put("Manzana", new Ingrediente("Manzana", TipoIngrediente.FRUTA_VERDURA,
                new InfoNutricionalUnidad(52, 14, 0.3, 0, 10.4, 0, 2.8, 2.6)));
        ingredientes.put("Atun", new Ingrediente("Atun", TipoIngrediente.PESCADO,
                new InfoNutricionalPeso(206, 0, 14, 3.3, 20, 0, 5, 0.5)));
        ingredientes.put("Cebolla", new Ingrediente("Cebolla", TipoIngrediente.FRUTA_VERDURA,
                new InfoNutricionalPeso(40, 9.3, 1.2, 0.1, 4.3, 0.3, 1.7, 1.4)));
        ingredientes.put("Garbanzos", new Ingrediente("Garbanzos", TipoIngrediente.LEGUMBRE,
                new InfoNutricionalPeso(164, 27, 8.6, 2.6, 5.5, 0, 4.2, 0.05)));
        ingredientes.put("Caldo", new Ingrediente("Caldo", "Caldo" /*otro tipo*/,
                new InfoNutricionalPeso(267, 18, 14, 3.4, 17, 17, 0, 23.875)));
        return ingredientes;
    }
}


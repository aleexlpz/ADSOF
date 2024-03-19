package Práctica_3;
import java.util.*;

public class Plato {
    private String nombre;
    private InfoNutricionalPlato infoplato;
    private HashMap<Ingrediente, Integer> ingredientes;
    private EnumSet<Alergeno> alergenos;


    public Plato(String nombre) {
        this.nombre = nombre;
        this.infoplato = new InfoNutricionalPlato(0, 0, 0, 0, 0, 0, 0, 0);
        this.ingredientes = new HashMap<>();
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }

    public boolean addIngrediente(Ingrediente ingrediente, int cantidad) {
        //Si el ingrediente ya esta en el plato, return false
        if (this.ingredientes.containsKey(ingrediente)) {
            return false;
        }
        else{
            this.ingredientes.put(ingrediente, cantidad);
            this.infoplato.addInfoNutricional(ingrediente.getInfoNutricional(), cantidad);
            this.alergenos.addAll(ingrediente.getAlergenos());
            return true;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public InfoNutricionalPlato getInfoNutricional() {
        return infoplato;
    }

    public EnumSet<Alergeno> getAlergenos() {
        return alergenos;
    }


    public void addPlato(Plato plato) {
        for (Map.Entry<Ingrediente, Integer> entry : plato.ingredientes.entrySet()) {
            this.addIngrediente(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "[Plato] "+ this.nombre + ": " + this.infoplato.toString()+ (this.alergenos.isEmpty() ? "" : " CONTIENE " + this.alergenos);

    }

}

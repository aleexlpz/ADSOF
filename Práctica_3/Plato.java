package Práctica_3;
import java.util.*;
/**
 * Clase que representa un plato de un menú.
 */
public class Plato {
    private String nombre;
    private InfoNutricionalPlato infoplato;
    private HashMap<Ingrediente, Integer> ingredientes;
    private EnumSet<Alergeno> alergenos;

    /**
     * Constructor de la clase Plato.
     * @param nombre Nombre del plato.
     */
    public Plato(String nombre) {
        this.nombre = nombre;
        this.infoplato = new InfoNutricionalPlato(0, 0, 0, 0, 0, 0, 0, 0);
        this.ingredientes = new HashMap<>();
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }

    /**
     * Metodo getter que devuelve el nombre del plato.
     * @return Nombre del plato.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo getter que devuelve la informacion nutricional del plato.
     * @return Informacion nutricional del plato.
     */
    public InfoNutricionalPlato getInfoNutricional() {
        return infoplato;
    }
    /**
     * Metodo getter que devuelve los ingredientes del plato.
     * @return Alergenos del plato.
     */
    public EnumSet<Alergeno> getAlergenos() {
        return alergenos;
    }
    /**
     * Metodo getter que devuelve los ingredientes del plato.
     * @return Ingredientes del plato.
     */
    public HashMap<Ingrediente, Integer> getIngredientes() {
        return ingredientes;
    }

    /**
     * Añade un ingrediente al plato.
     * @param ingrediente Ingrediente a añadir.
     * @param cantidad Cantidad del ingrediente a añadir.
     * @return true si el ingrediente se ha añadido correctamente, false en caso contrario.
     */
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

    /**
     * Añade un ingrediente del plato
     * @param plato Plato a añadir
     */
    public void addPlato(Plato plato) {
        for (Map.Entry<Ingrediente, Integer> entry : plato.ingredientes.entrySet()) {
            this.addIngrediente(entry.getKey(), entry.getValue());
        }
    }
    /**
     * Metodo toString que devuelve la informacion del plato.
     * @return Informacion del plato.
     */
    @Override
    public String toString() {
        return "[Plato] "+ this.nombre + ": " + this.infoplato.toString()+ (this.alergenos.isEmpty() ? "" : " CONTIENE " + this.alergenos);

    }

}

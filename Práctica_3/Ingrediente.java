package Práctica_3;
import java.util.*;
/**
 * Clase Ingrediente
 *
 */
public class Ingrediente {
    private String nombre;
    private Object tipo;
    private EnumSet<Alergeno> alergenos;
    private InfoNutricional infoNutricional;
    /**
     * Constructor de la clase Ingrediente
     * @param nombre nombre del ingrediente
     * @param tipo tipo del ingrediente
     * @param infoNutricional información nutricional del ingrediente
     */
    public Ingrediente(String nombre, Object tipo, InfoNutricional infoNutricional) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.infoNutricional= infoNutricional;
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }
    /**
     * Método getter que devuelve el nombre del ingrediente
     * @return el nombre del ingrediente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método getter que devuelve el tipo del ingrediente
     * @return el tipo del ingrediente
     */
    public Object getTipo() {
        return tipo;
    }

    /**
     * Método que comprueba si el ingrediente tiene alergenos
     * @param alergenos alergenos a añadir
     * @return el ingrediente con los alergenos añadidos
     */
    public Ingrediente tieneAlergenos(Alergeno... alergenos) {
        this.alergenos.addAll(EnumSet.copyOf(Arrays.asList(alergenos)));
        return this;
    }
    /**
     * Método getter que devuelve la información nutricional del ingrediente
     * @return el nombre del ingrediente
     */
    public InfoNutricional getInfoNutricional() {
        return infoNutricional;
    }
    /**
     * Método getter que devuelve los alergenos del ingrediente
     * @return el nombre del ingrediente
     */
    public EnumSet<Alergeno> getAlergenos() {
        return alergenos;
    }

    /**
     * Método toString del ingrediente
     */
    @Override
    public String toString() {

        return "[" + tipo + "] " + nombre + ": " + infoNutricional.toString() + (alergenos.isEmpty() ? "" : " CONTIENE " + alergenos.toString());
    }


}

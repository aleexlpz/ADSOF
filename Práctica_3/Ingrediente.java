package Práctica_3;
import java.util.*;

public class Ingrediente {
    private String nombre;
    private Object tipo;
    private EnumSet<Alergeno> alergenos;
    private InfoNutricional infoNutricional;

    public Ingrediente(String nombre, Object tipo, InfoNutricional infoNutricional) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.infoNutricional= infoNutricional;
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }

    public Ingrediente tieneAlergenos(Alergeno... alergenos) {
        this.alergenos.addAll(EnumSet.copyOf(Arrays.asList(alergenos)));
        return this;
    }
    public InfoNutricional getInfoNutricional() {
        return infoNutricional;
    }
    public EnumSet<Alergeno> getAlergenos() {
        return alergenos;
    }


    @Override
    public String toString() {
        String tipoString="";

        if (tipo instanceof String) {
            // Si es una cadena de texto, usarla directamente
            tipoString = (String) tipo;
        } else if (tipo instanceof TipoIngrediente) {
            // Si es una instancia de TipoIngrediente, formatearla correctamente
            tipoString = tipo.toString().replace("_", " ").toLowerCase();
            tipoString = tipoString.substring(0, 1).toUpperCase() + tipoString.substring(1);
        }

        // Construir la representación del tipo de ingrediente
        tipoString = "[" + tipoString + "]";

        String alergenosString = "";

        String infoNutricionalString = infoNutricional.toString();

        if (!alergenos.isEmpty()) {
            alergenosString += " CONTIENE ";
            for (Alergeno alergeno : alergenos) {
                alergenosString += alergeno.toString().toLowerCase() + ", ";
            }
            // Eliminar la coma final
            alergenosString = alergenosString.substring(0, alergenosString.length() - 2);
        }

        // Imprimir el nombre del ingrediente y su información nutricional
        return tipoString + " " + nombre + ": " + infoNutricionalString+ alergenosString;
    }


}

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

        return "[" + tipo + "] " + nombre + ": " + infoNutricional.toString() + (alergenos.isEmpty() ? "" : " CONTIENE " + alergenos.toString());
    }


}

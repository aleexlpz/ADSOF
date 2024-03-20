package Práctica_3;
import java.util.*;
import java.lang.*;

/**
 * Clase que representa un menú compuesto por varios platos.
 */
public class Menu {
    private int id;
    private static int ID = 1;
    private InfoNutricionalMenu infomenu;

    private ArrayList<Plato> platos;

    private EnumSet<Alergeno> alergenos;

    private ArrayList<String> platosNombre;


    /**
     * Constructor de la clase Menu.
     * @param platos platos
     */
    public Menu(Plato... platos) {
        this.id = ID++;
        this.infomenu = new InfoNutricionalMenu(0, 0, 0, 0, 0, 0, 0, 0);
        this.platos = new ArrayList<>();
        this.alergenos = EnumSet.noneOf(Alergeno.class);
        this.platosNombre = new ArrayList<>();
        for (Plato plato : platos) {
            this.addPlato(plato);
        }
    }
    public ArrayList<Plato> getPlatos() {
        return platos;
    }
    /**
     * Añade un plato al menú.
     * @param plato plato
     */
    public void addPlato(Plato plato) {
        this.platos.add(plato);
        this.infomenu.addInfoNutricional(plato.getInfoNutricional(), 1);
        this.alergenos.addAll(plato.getAlergenos());
        this.platosNombre.add(plato.getNombre());
    }

    /**
     * Metodo toString que devuelve la informacion del menu.
     * @return String
     */
    @Override
    public String toString() {
        return "Menu " + this.id +" " + this.platosNombre + ": " + this.infomenu.toString() +  (this.alergenos.isEmpty() ? "" : " CONTIENE " + this.alergenos);
    }
}




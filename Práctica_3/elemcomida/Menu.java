package Práctica_3.elemcomida;
import Práctica_3.enums.*;
import Práctica_3.nutricion.*;
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
    /**
     *  Metodo getter que devuelve los platos del menu
     * @return platos
     */
    public ArrayList<Plato> getPlatos() {
        return platos;
    }
    /**
     * Metodo getter que devuelve la infonutricional del menu
     * @return infonutricional
     */
    public InfoNutricionalMenu getInfo() {
        return this.infomenu;
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




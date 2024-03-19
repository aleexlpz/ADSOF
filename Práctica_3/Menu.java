package Práctica_3;
import java.util.*;
import java.lang.*;

/*En este apartado se pide crear la clase Menú, que contiene uno o más platos. Al crear un menú, se le asignará automáticamente un
identificador numérico único, que no puede modificarse una vez creado. A continuación
*/

public class Menu {
    private int id;
    private static int ID = 1;
    private InfoNutricionalMenu infomenu;

    private ArrayList<Plato> platos;

    private EnumSet<Alergeno> alergenos;

    private ArrayList<String> platosNombre;



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

    public void addPlato(Plato plato) {
        this.platos.add(plato);
        this.infomenu.addInfoNutricional(plato.getInfoNutricional(), 1);
        this.alergenos.addAll(plato.getAlergenos());
        this.platosNombre.add(plato.getNombre());
    }

    @Override
    public String toString() {
        //* Menu 1 [Macarrones, Tortilla]: INFORMACION NUTRICIONAL DEL MENU -> Valor energetico: 925.40 kcal, Hidratos de
        //carbono: 104.00 g, Grasas: 39.46 g, Saturadas: 4.59 g, Proteinas: 33.88 g, Azucares: 11.70 g, Fibra: 11.11 g,
        //Sodio: 265.00 mg. CONTIENE gluten, huevo, lactosa
        return "Menu " + this.id +" " + this.platosNombre + ": " + this.infomenu.toString() +  (this.alergenos.isEmpty() ? "" : " CONTIENE " + this.alergenos);
    }
}




package Práctica_3;
import java.util.*;
import java.lang.*;

/*En este apartado se pide crear la clase Menú, que contiene uno o más platos. Al crear un menú, se le asignará automáticamente un
identificador numérico único, que no puede modificarse una vez creado. A continuación
*/

public class Menu {
    private static int contador = 1;
    private int id;
    private HashMap<String, Plato> platos;

    String mnombre = "";
    double mcalorias = 0;
    double mhidratos = 0;
    double mgrasastotales = 0;
    double mgrasassaturadas = 0;
    double mproteinas = 0;
    double mazucares = 0;
    double mfibra = 0;
    double msodio = 0;

    public Menu(Plato... platos) {
        this.id = contador++;
        this.platos = new HashMap<>();
        for(Plato plato : platos){
            this.platos.put(plato.getNombre(), plato);
        }
    }


    @Override
    public String toString() {

        EnumSet<Alergeno> alergenos = EnumSet.noneOf(Alergeno.class);
        for(Plato plato : platos.values()){
            mcalorias += plato.getPcalorias();
            mhidratos += plato.getPhidratos();
            mgrasastotales += plato.getPgrasastotales();
            mgrasassaturadas += plato.getPgrasassaturadas();
            mproteinas += plato.getPproteinas();
            mazucares += plato.getPazucares();
            mfibra += plato.getPfibra();
            msodio += plato.getPsodio();
            alergenos.addAll(plato.getAlergenos());

        }

        StringBuilder sb = new StringBuilder();
        sb.append("Menu ").append(this.id).append(" [");
        for (Plato plato : platos.values()) {
            sb.append(plato.getNombre()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Eliminar la última coma y el espacio
        sb.append("]: ");
        sb.append(String.format(Locale.US, "INFORMACION NUTRICIONAL DEL MENU -> Valor energetico: %.2f kcal, Hidratos de carbono: %.2f g, Grasas: %.2f g, Saturadas: %.2f g, Proteinas: %.2f g, Azucares: %.2f g, Fibra: %.2f g, Sodio: %.2f mg.", mcalorias, mhidratos, mgrasastotales, mgrasassaturadas, mproteinas, mazucares, mfibra, msodio));

        if (!alergenos.isEmpty()) {
            sb.append(" CONTIENE ");
            for (Alergeno alergeno : alergenos) {
                sb.append(alergeno.toString().toLowerCase()).append(", ");
            }
            // Eliminar la coma final
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}




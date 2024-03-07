package Práctica_3;
import java.util.*;

public class Plato {
    private String nombre;
    private HashMap<Ingrediente, Integer> ingredientes;

    private EnumSet<Alergeno> alergenos;
    protected double pcalorias;
    protected double phidratos;
    protected double pgrasastotales;
    protected double pgrasassaturadas;
    protected double pproteinas;
    protected double pazucares;
    protected double pfibra;
    protected double psodio;

    public Plato(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new HashMap<>();
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }

    public boolean addIngrediente(Ingrediente ingrediente, int cantidad) {
        if (ingredientes.containsKey(ingrediente)) {
            return false;
        } else {
            //tengo q comprobar si el la info nutricional de los ingredientes es por peso o por unidad
            if(ingrediente.getInfoNutricional() instanceof InfoNutricionalPeso){
                ingredientes.put(ingrediente, cantidad);
                pcalorias += ingrediente.getInfoNutricional().getCalorias() * cantidad / 100.0;
                phidratos += ingrediente.getInfoNutricional().getHidratos() * cantidad / 100.0;
                pgrasastotales += ingrediente.getInfoNutricional().getGrasasTotales() * cantidad / 100.0;
                pgrasassaturadas += ingrediente.getInfoNutricional().getGrasasSaturadas() * cantidad / 100.0;
                pproteinas += ingrediente.getInfoNutricional().getProteinas() * cantidad / 100.0;
                pazucares += ingrediente.getInfoNutricional().getAzucares() * cantidad / 100.0;
                pfibra += ingrediente.getInfoNutricional().getFibra() * cantidad / 100.0;
                psodio += ingrediente.getInfoNutricional().getSodio() * cantidad / 100.0;
                alergenos.addAll(ingrediente.getAlergenos());

            }
            else{
            ingredientes.put(ingrediente, cantidad);
            pcalorias += ingrediente.getInfoNutricional().getCalorias() * cantidad ;
            phidratos += ingrediente.getInfoNutricional().getHidratos() * cantidad ;
            pgrasastotales += ingrediente.getInfoNutricional().getGrasasTotales() * cantidad ;
            pgrasassaturadas += ingrediente.getInfoNutricional().getGrasasSaturadas() * cantidad ;
            pproteinas += ingrediente.getInfoNutricional().getProteinas() * cantidad ;
            pazucares += ingrediente.getInfoNutricional().getAzucares() * cantidad ;
            pfibra += ingrediente.getInfoNutricional().getFibra() * cantidad ;
            psodio += ingrediente.getInfoNutricional().getSodio() * cantidad ;
            alergenos.addAll(ingrediente.getAlergenos());
        }
            return true;
        }
    }

    public void addPlato(Plato plato) {
        for (Map.Entry<Ingrediente, Integer> entry : plato.ingredientes.entrySet()) {
            this.addIngrediente(entry.getKey(), entry.getValue());
        }
    }

    //* [Plato] Tortilla: INFORMACION NUTRICIONAL DEL PLATO -> Valor energetico: 385.20 kcal, Hidratos de carbono:
    //27.10 g, Grasas: 22.75 g, Saturadas: 1.68 g, Proteinas: 16.20 g, Azucares: 1.20 g, Fibra: 3.90 g, Sodio: 3.40 mg.
    //CONTIENE huevo
    @Override
    public String toString() {
        String alergenosString = "";

        if (!alergenos.isEmpty()) {
            alergenosString += " CONTIENE ";
            for (Alergeno alergeno : alergenos) {
                alergenosString += alergeno.toString().toLowerCase() + ", ";
            }
            // Eliminar la coma final
            alergenosString = alergenosString.substring(0, alergenosString.length() - 2);
        }

        return String.format(Locale.US, "[Plato]  %s: INFORMACION NUTRICIONAL DEL PLATO -> Valor energetico: %.2f kcal, Hidratos de carbono: %.2f g, Grasas: %.2f g, Saturadas: %.2f g, Proteinas: %.2f g, Azucares: %.2f g, Fibra: %.2f g, Sodio: %.2f mg.%s",
                this.nombre, pcalorias, phidratos, pgrasastotales, pgrasassaturadas, pproteinas, pazucares, pfibra, psodio, alergenosString);
    }

}

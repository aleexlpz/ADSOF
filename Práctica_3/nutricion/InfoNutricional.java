package Práctica_3.nutricion;
import Práctica_3.enums.*;
import java.util.*;
/**
 * Clase abstracta que representa la informacion nutricional de un alimento
 */
public abstract class InfoNutricional {
    protected double calorias;
    protected double hidratos;
    protected double grasastotales;
    protected double grasassaturadas;
    protected double proteinas;
    protected double azucares;
    protected double fibra;
    protected double sodio;
    protected EnumSet<Alergeno> alergenos;

    /**
     * Constructor de la clase InfoNutricional
     * @param calorias Calorias del alimento
     * @param hidratos Hidratos de carbono del alimento
     * @param grasastotales Grasas totales del alimento
     * @param grasassaturadas Grasas saturadas del alimento
     * @param proteinas Proteinas del alimento
     * @param azucares Azucares del alimento
     * @param fibra Fibra del alimento
     * @param sodio Sodio del alimento
     */
    public InfoNutricional(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        this.calorias = calorias;
        this.hidratos = hidratos;
        this.grasastotales = grasastotales;
        this.grasassaturadas = grasassaturadas;
        this.proteinas = proteinas;
        this.azucares = azucares;
        this.fibra = fibra;
        this.sodio = sodio;
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }
    /**
     * Metodo que devuelve las calorias del alimento
     * @return Calorias del alimento
     */
    public double getCalorias() {
        return calorias;
    }

    /**
     * Metodo que devuelve los hidratos de carbono del alimento
     * @return Hidratos de carbono del alimento
     */
    public double getHidratos() {
        return hidratos;
    }

    /**
     * Metodo que devuelve las grasas totales del alimento
     * @return Grasas totales del alimento
     */
    public double getGrasasTotales() {
        return grasastotales;
    }

    /**
     * Metodo que devuelve las grasas saturadas del alimento
     * @return  Grasas saturadas del alimento
     */
    public double getGrasasSaturadas() {
        return grasassaturadas;
    }
    /**
     * Metodo que devuelve las proteinas del alimento
     * @return Proteinas del alimento
     */
    public double getProteinas() {
        return proteinas;
    }
    /**
     * Metodo que devuelve los azucares del alimento
     * @return Azucares del alimento
     */
    public double getAzucares() {
        return azucares;
    }
    /**
     * Metodo que devuelve la fibra del alimento
     * @return Fibra del alimento
     */
    public double getFibra() {
        return fibra;
    }
    /**
     * Metodo que devuelve el sodio del alimento
     * @return Sodio del alimento
     */
    public double getSodio() {
        return sodio;
    }
    /**
     * Metodo que devuelve los alergenos del alimento
     * @return Alergenos del alimento
     */
    public EnumSet<Alergeno> getAlergenos() {
        return alergenos;
    }

    /**
     * Metodo que va sumando la informacion nutricional
     * @param info Informacion nutricional del alimento a añadir
     * @param cantidad Cantidad de alimento a añadir
     * @return Suma de informacion nutricional añadida
     */
    public InfoNutricional addInfoNutricional(InfoNutricional info, int cantidad){
        if (info instanceof  InfoNutricionalUnidad){
        this.calorias += info.getCalorias() * cantidad;
        this.hidratos += info.getHidratos() * cantidad;
        this.grasastotales += info.getGrasasTotales() * cantidad;
        this.grasassaturadas += info.getGrasasSaturadas() * cantidad;
        this.proteinas += info.getProteinas() * cantidad;
        this.azucares += info.getAzucares() * cantidad;
        this.fibra += info.getFibra() * cantidad;
        this.sodio += info.getSodio() * cantidad;
        }

        else if (info instanceof  InfoNutricionalPeso){
            this.calorias += (info.getCalorias() * cantidad)/100;
            this.hidratos += (info.getHidratos() * cantidad)/100;
            this.grasastotales += (info.getGrasasTotales() * cantidad)/100;
            this.grasassaturadas += (info.getGrasasSaturadas() * cantidad)/100;
            this.proteinas += (info.getProteinas() * cantidad)/100;
            this.azucares += (info.getAzucares() * cantidad)/100;
            this.fibra += (info.getFibra() * cantidad)/100;
            this.sodio += (info.getSodio() * cantidad)/100;

        }
        else if (info instanceof  InfoNutricionalPlato){
            this.calorias += info.getCalorias();
            this.hidratos += info.getHidratos();
            this.grasastotales += info.getGrasasTotales();
            this.grasassaturadas += info.getGrasasSaturadas();
            this.proteinas += info.getProteinas();
            this.azucares += info.getAzucares();
            this.fibra += info.getFibra();
            this.sodio += info.getSodio();
        }
        this.alergenos.addAll(info.getAlergenos());
            return this;
        }
        /**
         * Metodo toString que devuelve la informacion nutricional del alimento
         * @return Informacion nutricional del alimento
         */
        @Override
        public String toString() {
            return String.format(Locale.US,"Valor energetico: %.2f kcal, Hidratos de carbono: %.2f g, Grasas: %.2f g, Saturadas: %.2f g, Proteinas: %.2f g, Azucares: %.2f g, Fibra: %.2f g, Sodio: %.2f mg.",
                    this.calorias, this.hidratos, this.grasastotales, this.grasassaturadas, this.proteinas, this.azucares, this.fibra, this.sodio);
        }


}

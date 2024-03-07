package Práctica_3;
import java.util.*;

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

    public InfoNutricional(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        this.calorias = calorias;
        this.hidratos = hidratos;
        this.grasastotales = grasastotales;
        this.grasassaturadas = grasassaturadas;
        this.proteinas = proteinas;
        this.azucares = azucares;
        this.fibra = fibra;
        this.sodio = sodio;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getHidratos() {
        return hidratos;
    }

    public double getGrasasTotales() {
        return grasastotales;
    }

    public double getGrasasSaturadas() {
        return grasassaturadas;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getAzucares() {
        return azucares;
    }

    public double getFibra() {
        return fibra;
    }

    public double getSodio() {
        return sodio;
    }



    public abstract String toString();

}

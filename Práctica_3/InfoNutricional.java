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
    protected ArrayList<Alergeno> alergenos;

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

    public abstract String toString();

}

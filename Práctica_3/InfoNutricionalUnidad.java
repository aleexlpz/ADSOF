package Práctica_3;

import java.util.ArrayList;
import java.util.Locale;

public class InfoNutricionalUnidad extends InfoNutricional{
    public double factor = 1;

    public InfoNutricionalUnidad(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);
    }
    public double getFactor() {
        return factor;
    }
    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL POR UNIDAD -> "+ super.toString();
    }

}

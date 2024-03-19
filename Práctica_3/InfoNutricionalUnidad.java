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
        return String.format(Locale.US,"INFORMACION NUTRICIONAL POR UNIDAD -> Valor energetico: %.2f kcal, Hidratos de carbono: %.2f g, Grasas: %.2f g, Saturadas: %.2f g, Proteinas: %.2f g, Azucares: %.2f g, Fibra: %.2f g, Sodio: %.2f mg.",
                calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);
    }

}

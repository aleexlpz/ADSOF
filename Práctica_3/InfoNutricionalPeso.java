package Práctica_3;

import java.util.ArrayList;
import java.util.Locale;

public class InfoNutricionalPeso extends InfoNutricional {

    public InfoNutricionalPeso(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }

    @Override
    public String toString() {
        return String.format(Locale.US, "INFORMACION NUTRICIONAL POR 100 g -> Valor energetico: %.2f kcal, Hidratos de carbono: %.2f g, Grasas: %.2f g, Saturadas: %.2f g, Proteinas: %.2f g, Azucares: %.2f g, Fibra: %.2f g, Sodio: %.2f mg.",
                calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);
}

}

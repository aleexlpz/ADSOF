package Práctica_3;

import java.util.ArrayList;
import java.util.Locale;

public class InfoNutricionalPeso extends InfoNutricional {



    public InfoNutricionalPeso(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }



    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL POR 100 g ->"+ super.toString();

}

}

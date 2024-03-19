package Práctica_3;


public class InfoNutricionalPlato extends InfoNutricional {

    public InfoNutricionalPlato(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }

    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL DEL PLATO -> "+ super.toString();

    }

}

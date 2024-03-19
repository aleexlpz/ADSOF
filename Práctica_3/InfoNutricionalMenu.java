package Práctica_3;

public class InfoNutricionalMenu extends InfoNutricional{

    public InfoNutricionalMenu(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }

    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL DEL MENU -> "+ super.toString();

    }
}
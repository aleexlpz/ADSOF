package Práctica_3.nutricion;

/**
 * Clase que representa la información nutricional en función de su peso
 */
public class InfoNutricionalPeso extends InfoNutricional {
    /**
     * Constructor de la clase InfoNutricionalPeso
     * @param calorias
     * @param hidratos
     * @param grasastotales
     * @param grasassaturadas
     * @param proteinas
     * @param azucares
     * @param fibra
     * @param sodio
     */
    public InfoNutricionalPeso(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }
    /**
     * Método que devuelve la información nutricional en función de su peso
     * @return String
     */
    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL POR 100 g -> "+ super.toString();

}

}

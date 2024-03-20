package Práctica_3;

/**
 * Clase que representa la información nutricional de un plato
 */
public class InfoNutricionalPlato extends InfoNutricional {
    /**
     * Constructor de la clase InfoNutricionalPlato
     * @param calorias
     * @param hidratos
     * @param grasastotales
     * @param grasassaturadas
     * @param proteinas
     * @param azucares
     * @param fibra
     * @param sodio
     */
    public InfoNutricionalPlato(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }
    /**
     * Método toString que devuelve la información nutricional del plato
     * @return String
     */
    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL DEL PLATO -> "+ super.toString();

    }

}

package Práctica_3.nutricion;

/**
 * Clase que representa la información nutricional en  unidades
 */
public class InfoNutricionalUnidad extends InfoNutricional{
    /**
     * Constructor de la clase InfoNutricionalUnidad
     * @param calorias Calorías
     * @param hidratos Hidratos de carbono
     * @param grasastotales Grasas totales
     * @param grasassaturadas Grasas saturadas
     * @param proteinas Proteínas
     * @param azucares Azúcares
     * @param fibra Fibra
     * @param sodio Sodio
     */
    public InfoNutricionalUnidad(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);
    }
    /**
     * Método toString que devuelve la información nutricional en unidades
     * @return Información nutricional en unidades
     */
    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL POR UNIDAD -> "+ super.toString();
    }

}

package Práctica_3;
/**
 * Clase que representa la informacion nutricional de un menu
 */
public class InfoNutricionalMenu extends InfoNutricional{
    /**
     * Constructor de la clase InfoNutricionalMenu
     * @param calorias
     * @param hidratos
     * @param grasastotales
     * @param grasassaturadas
     * @param proteinas
     * @param azucares
     * @param fibra
     * @param sodio
     */
    public InfoNutricionalMenu(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        super(calorias, hidratos, grasastotales, grasassaturadas, proteinas, azucares, fibra, sodio);

    }
    /**
     * Metodo toString que devuelve la informacion nutricional del menu
     * @return String
     */
    @Override
    public String toString() {
        return "INFORMACION NUTRICIONAL DEL MENU -> "+ super.toString();

    }
}
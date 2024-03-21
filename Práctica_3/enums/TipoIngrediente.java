package Práctica_3.enums;
/**
 * Enumerado que representa los tipos de ingredientes que puede contener un plato.
 */
public enum TipoIngrediente {
    CEREAL( "Cereal"),
    LEGUMBRE( "Legumbre"),
    LACTEO( "Lácteo"),
    CARNE( "Carne"),
    PESCADO("Pescado"),
    HUEVO( "Huevo"),
    FRUTA_VERDURA("Frutas y verduras"),
    CALDO( "Caldo"),
    OTROS("Otros");
    private final String nombre;

    /**
     * Constructor de la clase TipoIngrediente.
     * @param nombre Nombre del tipo de ingrediente.
     */
    TipoIngrediente(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo toString que devuelve el nombre del tipo de ingrediente.
     * @return Nombre del tipo de ingrediente.
     */
    public String toString() {
        return nombre;
    }

}

package Práctica_3;
/**
 * Enumerado que representa los tipos de ingredientes que puede contener un plato.
 */
public enum TipoIngrediente {
    CEREAL( "Cereal"),
    FRUTA( "Fruta"),
    LEGUMBRE( "Legumbre"),
    LACTEO( "Lácteo"),
    CARNE( "Carne"),
    PESCADO("Pescado"),
    HUEVO( "Huevo"),
    FRUTA_VERDURA("Frutas y verduras"),
    CALDO( "Caldo");
    private final String nombre;

    TipoIngrediente(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }

}

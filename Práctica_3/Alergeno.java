package Práctica_3;
/**
 * Enumerado que representa los alérgenos que puede contener un plato.
 */
public enum Alergeno {
    GLUTEN("gluten"),
    HUEVO("huevo"),
    LACTOSA("lactosa"),
    FRUTOS_SECOS("frutos secos");

    private final String nombre;
    /**
     * Constructor de la clase Alergeno.
     * @param nombre Nombre del alérgeno.
     */
    Alergeno(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }
}

package Práctica_3.enums;

/**
 * Enumerado que representa los alérgenos que puede contener un plato.
 */
public enum Alergeno {
    GLUTEN("gluten"),
    LACTOSA("lactosa"),
    FRUTOS_SECOS("frutos secos"),
    HUEVO("huevo");

    private final String nombre;
    /**
     * Constructor de la clase Alergeno.
     * @param nombre Nombre del alérgeno.
     */
    Alergeno(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo toString que devuelve el nombre del alérgeno.
     * @return Nombre del alérgeno.
     */
    public String toString() {
        return nombre;
    }
}

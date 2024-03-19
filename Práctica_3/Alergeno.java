package Práctica_3;

public enum Alergeno {
    GLUTEN("gluten"),
    HUEVO("huevo"),
    LACTOSA("lactosa"),
    FRUTOS_SECOS("frutos secos");

    private final String nombre;

    Alergeno(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }
}

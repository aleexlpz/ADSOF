package Práctica_3;
/*Extiende tu implementación para poder leer ingredientes, platos y menús de un fichero de texto; y para poder guardar una lista de
menús a fichero. Cuando se guarde un menú a fichero, también deberán guardarse los platos e ingredientes que lo componen, directa o
indirectamente. Además, el fichero no podrá contener ingredientes, platos ni menús repetidos. En los ficheros, cada ingrediente se
definirá en 1 línea distinta con el siguiente formato:
(INGREDIENTE_PESO|INGREDIENTE_UNIDAD);NOMBRE;TIPO;CALORIAS;HIDRATOS;GRASAS_TOTALES;GRASAS_SATURADAS;
PROTEINAS;AZUCARES;FIBRA;SODIO;GLUTEN;LACTOSA;FRUTOS_SECOS;HUEVO
Cada plato se definirá en 1 línea distinta con el siguiente formato:
PLATO;nombre(;INGREDIENTE nombre:cantidad|PLATO nombre)+
Cada menú se definirá en 1 línea distinta con el siguiente formato: MENU(;plato)+
El siguiente listado muestra un fichero con formato válido:
INGREDIENTE_PESO;Pasta;CEREAL;372.0;74.0;1.8;0.277;12.0;2.6;2.9;6.0;S;N;N;S
INGREDIENTE_UNIDAD;Tomate;FRUTA_VERDURA;14.0;2.2;0.2;0.0;0.7;2.04;1.0;4.0;N;N;N;N
INGREDIENTE_PESO;Aceite;Grasa;885.0;0.0;100.0;12.81;0.0;0.0;0.0;2.0;N;N;N;N
INGREDIENTE_PESO;Chorizo;CARNE;203.0;5.0;14.3;4.6;13.6;0.0;2.0;800.0;N;S;N;N
PLATO;Macarrones;INGREDIENTE Pasta:90;INGREDIENTE Tomate:4;INGREDIENTE Aceite:10;INGREDIENTE Chorizo:30
INGREDIENTE_UNIDAD;Huevo;HUEVO;84.6;0.35;6.3;0.2;6.6;0.6;0.0;0.1;N;N;N;S
INGREDIENTE_PESO;Patata;FRUTA_VERDURA;85.0;17.6;0.1;0.0;2.0;0.0;2.6;2.0;N;N;N;N
PLATO;Tortilla;INGREDIENTE Huevo:2;INGREDIENTE Patata:150;INGREDIENTE Aceite:10
MENU;Macarrones;Tortilla
INGREDIENTE_PESO;Caldo;Caldo;267.0;18.0;14.0;3.4;17.0;17.0;0.0;23.875;N;N;N;N
PLATO;Tortilla guisada;PLATO Tortilla;INGREDIENTE Caldo:80
MENU;Macarrones;Tortilla guisada
MENU;Macarrones*/

public class ManejadorFicheros {

    public static void guardarFichero(String s, Object o) {
    }
    public static void leerFichero(String s) {
    }
    public static List<Menu> getMenus() {
        return null;
    }
}

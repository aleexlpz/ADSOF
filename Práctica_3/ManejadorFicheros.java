package Práctica_3;
import java.util.*;
import java.io.*;
import java.lang.*;

public class ManejadorFicheros {

    private static Set<Ingrediente> ingredientes = null;
    private static Set<Plato> platos = null;
    private static Set<Menu> menus = null;


    ManejadorFicheros () {
        ingredientes = new HashSet<>();
        platos = new HashSet<>();
        menus = new HashSet<>();
    }
    /**
     * Guarda una lista de menús en un fichero.
     * @param nombreFichero nombre del fichero
     * @param menus lista de menús
     */
    public static void guardarFichero(String nombreFichero, List<Menu> menus) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombreFichero);
            StringBuilder menuwriter = new StringBuilder();
            Set<String> platosEscritos = new HashSet<>();
            Set<String> ingredientesEscritos = new HashSet<>();

            for (Menu menu : menus) {
                for (Plato plato : menu.getPlatos()) {
                    if (!platosEscritos.contains(plato.getNombre())) {
                        platosEscritos.add(plato.getNombre());

                        for (Ingrediente ingrediente : plato.getIngredientes().keySet()) {
                            String nombreIngrediente = ingrediente.getNombre();
                            if (!ingredientesEscritos.contains(nombreIngrediente)) {
                                ingredientesEscritos.add(nombreIngrediente);
                                if (ingrediente.getInfoNutricional() instanceof InfoNutricionalPeso) {
                                    menuwriter.append("INGREDIENTE_PESO;");
                                } else if (ingrediente.getInfoNutricional() instanceof InfoNutricionalUnidad) {
                                    menuwriter.append("INGREDIENTE_UNIDAD;");
                                }
                                menuwriter.append(nombreIngrediente).append(";");
                                if (ingrediente.getTipo() instanceof TipoIngrediente) {
                                    menuwriter.append(((TipoIngrediente)ingrediente.getTipo()).name());
                                } else {
                                    menuwriter.append(ingrediente.getTipo().toString());
                                }
                                menuwriter.append(";").append(ingrediente.getInfoNutricional().getCalorias()).append(";").append(ingrediente.getInfoNutricional().getHidratos()).append(";").append(ingrediente.getInfoNutricional().getGrasasTotales()).append(";").append(ingrediente.getInfoNutricional().getGrasasSaturadas()).append(";").append(ingrediente.getInfoNutricional().getProteinas()).append(";").append(ingrediente.getInfoNutricional().getAzucares()).append(";").append(ingrediente.getInfoNutricional().getFibra()).append(";").append(ingrediente.getInfoNutricional().getSodio());

                                boolean contieneAlergeno;
                                for (Alergeno alergeno : Alergeno.values()) {
                                    contieneAlergeno = ingrediente.getAlergenos().contains(alergeno);
                                    menuwriter.append(";");
                                    menuwriter.append(contieneAlergeno ? "S" : "N");
                                }
                                menuwriter.append("\n");

                            }
                        }

                        menuwriter.append("PLATO;").append(plato.getNombre());

                        for (Ingrediente ingrediente : plato.getIngredientes().keySet()) {
                            menuwriter.append(";INGREDIENTE ").append(ingrediente.getNombre()).append(":").append(plato.getIngredientes().get(ingrediente));
                        }

                        menuwriter.append("\n");
                    }
                }

                menuwriter.append("MENU");
                for (Plato plato : menu.getPlatos()) {
                    if (!platosEscritos.contains(plato.getNombre())) {
                        menuwriter.append(";").append(plato.getNombre());
                        platosEscritos.add(plato.getNombre());
                    }
                }

                menuwriter.append("\n");
            }

            fichero.write(menuwriter.toString());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
    /**
     * Lee una lista de menús de un fichero.
     * @param nombreFichero nombre del fichero
     */

    public static void leerFichero(String nombreFichero) {
        FileReader fichero = null;
        BufferedReader lector = null;
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        try {
            fichero = new FileReader(nombreFichero);
            lector = new BufferedReader(fichero);
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes[0].equals("INGREDIENTE_PESO")) {

                    InfoNutricionalPeso infoN = new InfoNutricionalPeso(Double.parseDouble(partes[3]), Double.parseDouble(partes[4]), Double.parseDouble(partes[5]), Double.parseDouble(partes[6]), Double.parseDouble(partes[7]), Double.parseDouble(partes[8]), Double.parseDouble(partes[9]), Double.parseDouble(partes[10]));
                    List<Alergeno> alergenos= new ArrayList<>();
                    if(partes[11].equals("S")){
                        alergenos.add(Alergeno.GLUTEN);
                    }
                    if(partes[12].equals("S")){
                        alergenos.add(Alergeno.LACTOSA);
                    }
                    if(partes[13].equals("S")){
                        alergenos.add(Alergeno.FRUTOS_SECOS);
                    }
                    if(partes[14].equals("S")){
                        alergenos.add(Alergeno.HUEVO);
                    }
                    if(!alergenos.isEmpty()) {
                        ingredientes.add(new Ingrediente(partes[1], partes[2], infoN).tieneAlergenos(alergenos.toArray(new Alergeno[0])));
                    }else{
                        ingredientes.add(new Ingrediente(partes[1], partes[2], infoN));
                    }

                } else if (partes[0].equals("INGREDIENTE_UNIDAD")) {
                    InfoNutricionalUnidad infoN = new InfoNutricionalUnidad(Double.parseDouble(partes[3]), Double.parseDouble(partes[4]), Double.parseDouble(partes[5]), Double.parseDouble(partes[6]), Double.parseDouble(partes[7]), Double.parseDouble(partes[8]), Double.parseDouble(partes[9]), Double.parseDouble(partes[10]));
                    List<Alergeno> alergenos= new ArrayList<>();
                    if(partes[11].equals("S")){
                        alergenos.add(Alergeno.GLUTEN);
                    }
                    if(partes[12].equals("S")){
                        alergenos.add(Alergeno.LACTOSA);
                    }
                    if(partes[13].equals("S")){
                        alergenos.add(Alergeno.FRUTOS_SECOS);
                    }
                    if(partes[14].equals("S")){
                        alergenos.add(Alergeno.HUEVO);
                    }
                    if(!alergenos.isEmpty()) {
                        ingredientes.add(new Ingrediente(partes[1], partes[2], infoN).tieneAlergenos(alergenos.toArray(new Alergeno[0])));
                    }else{
                        ingredientes.add(new Ingrediente(partes[1], partes[2], infoN));
                    }
                } else if (partes[0].equals("PLATO")) {
                    Plato plato = new Plato(partes[1]);
                    for (int i = 2; i < partes.length; i++) {
                        String[] partesIngrediente = partes[i].split(":");
                        String[] ing = partesIngrediente[0].split("\\s+");
                        Ingrediente ingrediente = null;

                        if (ing[0].equals("INGREDIENTE")) {
                            for (Ingrediente ingrediente1 : ingredientes) {
                                if (ingrediente1.getNombre().equals(ing[1])) {
                                    ingrediente = ingrediente1;
                                }
                            }
                        }
                        plato.addIngrediente(ingrediente, Integer.parseInt(partesIngrediente[1]));

                    }
                    platos.add(plato);
                } else if (partes[0].equals("MENU")) {
                    Menu menu = new Menu();
                    for (int i = 1; i < partes.length; i++) {
                        for (Plato plato : platos) {
                            if (plato.getNombre().equals(partes[i])) {
                                menu.addPlato(plato);
                            }
                        }
                    }
                    menus.add(menu);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
    /**
     * Devuelve la lista de ingredientes leída del fichero.
     * @return lista de ingredientes
     */
    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     * Devuelve la lista de platos leída del fichero.
     * @return lista de platos
     */
    public Set<Plato> getPlatos() {
        return platos;
    }

    /**
     * Devuelve la lista de menús leída del fichero.
     * @return lista de menús
     */
    public static Set<Menu> getMenus() {
        return menus;
    }
}


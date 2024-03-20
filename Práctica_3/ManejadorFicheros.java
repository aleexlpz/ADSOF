package Práctica_3;
import java.util.*;
import java.io.*;
public class ManejadorFicheros {
    public static void guardarFichero(String nombreFichero, List<Menu> menus) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombreFichero);
            StringBuilder menuwriter = new StringBuilder();
            Set<String> platosEscritos = new HashSet<>();
            for (Menu menu : menus) {
                for (Plato plato : menu.getPlatos()) {
                    if (!platosEscritos.contains(plato.getNombre())) {
                        platosEscritos.add(plato.getNombre());
                        for (Ingrediente ingrediente : plato.getIngredientes().keySet()) {
                            if (ingrediente.getInfoNutricional() instanceof InfoNutricionalPeso) {
                                menuwriter.append("INGREDIENTE_PESO;");
                            } else if (ingrediente.getInfoNutricional() instanceof InfoNutricionalUnidad) {
                                menuwriter.append("INGREDIENTE_UNIDAD;");
                            }
                            menuwriter.append(ingrediente.getNombre()).append(";").append(ingrediente.getTipo()).append(";").append(ingrediente.getInfoNutricional().getCalorias()).append(";").append(ingrediente.getInfoNutricional().getProteinas()).append(";").append(ingrediente.getInfoNutricional().getHidratos()).append(";").append(ingrediente.getInfoNutricional().getGrasasTotales()).append(";").append(ingrediente.getInfoNutricional().getGrasasSaturadas()).append(ingrediente.getInfoNutricional().getFibra()).append(";").append(ingrediente.getInfoNutricional().getSodio()).append(";\n");
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
    /*public static void leerFichero(String nombreFichero) {
        return null;
    }*/


}

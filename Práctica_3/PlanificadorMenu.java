/**
 * Esta clase implementa un planificador que menus que cumple con los criterios dados
 *
 * @author Alejandro López Martínez y Sofía García Héras
 *
 */
package Práctica_3;

import java.util.*;

public class PlanificadorMenu {
    private List<Plato> platos;
    private List<Plato> platosValidos;
    private Map<ElementoNutricional, Double> maximos = new EnumMap<>(ElementoNutricional.class);
    private List<Alergeno> alergenos = new ArrayList<>();

    /**
     * Constructor que inicializa el objeto planificador con una lista de platos
     *
     * @param platos lista de platos
     */
    public PlanificadorMenu(List<Plato> platos) {
        this.platos = new ArrayList<>(platos);
        for(ElementoNutricional e: ElementoNutricional.values()) {
            maximos.put(e, Double.MAX_VALUE);
        }
    }

    /**
     * Añade un máximo de un elemento nutricional
     *
     * @param elemento elemento nutricional
     * @param maximo máximo
     * @return el planificador con el máximo añadido
     */
    public PlanificadorMenu conMaximo(ElementoNutricional elemento, double maximo) {
        this.maximos.put(elemento, maximo);
        return this;
    }

    /**
     * Añade alergenos que no deben estar en los platos
     *
     * @param alergenos alergenos a añadir
     * @return el planificador con los alergenos añadidos
     */
    public PlanificadorMenu sinAlergenos(Alergeno... alergenos) {
        this.alergenos.addAll(Arrays.asList(alergenos));
        return this;
    }

    /**
     * Planifica un menú que cumple con los criterios dados
     *
     * @param min mínimo de calorías
     * @param max máximo de calorías
     * @return el menú planificado
     */
    public Menu planificar(int min, int max) {

        List<Plato> platosTmp = new ArrayList<>();
        List<Plato> combinacionDef = null;
        platosValidos = new ArrayList<>();
        int caloriasDef = Integer.MAX_VALUE;


        for(Plato p: platos) {
            boolean contieneAlergeno = false;
            for(Alergeno a: alergenos) {
                if(p.getAlergenos().contains(a)) {
                    contieneAlergeno = true;
                    break;
                }
            }
            if(!contieneAlergeno) {
                platosTmp.add(p);
            }
        }
        for (Plato plato : platosTmp) {
            boolean cumpleNutrientes = true;

            if (plato.getInfoNutricional().getHidratos() > maximos.get(ElementoNutricional.HIDRATOS) ||
                    plato.getInfoNutricional().getGrasasSaturadas() > maximos.get(ElementoNutricional.GRASA_SATURADA) ||
                    plato.getInfoNutricional().getGrasasTotales() > maximos.get(ElementoNutricional.GRASA_TOTAL) ||
                    plato.getInfoNutricional().getSodio() > maximos.get(ElementoNutricional.SODIO) ||
                    plato.getInfoNutricional().getFibra() > maximos.get(ElementoNutricional.FIBRA) ||
                    plato.getInfoNutricional().getProteinas() > maximos.get(ElementoNutricional.PROTEINAS) ||
                    plato.getInfoNutricional().getAzucares() > maximos.get(ElementoNutricional.AZUCARES)) {
                cumpleNutrientes = false;
            }

            if(cumpleNutrientes) {
                platosValidos.add(plato);
            }
        }
        int n = platosValidos.size();

        for (int i = 1; i < (1 << n); i++) {
            List<Plato> combPlatos1 = new ArrayList<>();
            int calorias1 = 0;

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    Plato platoActual = platosValidos.get(j);
                    combPlatos1.add(platoActual);
                    calorias1 += platoActual.getInfoNutricional().getCalorias();
                }
            }
            // Comprobar si la combinación actual es mejor y se ajusta al rango de calorías
            if (calorias1 >= min && calorias1 <= max && (calorias1 - min) < (caloriasDef - min)) {
                combinacionDef = combPlatos1;
                caloriasDef = calorias1;
            }
        }
        if (combinacionDef != null) {
            return new Menu(combinacionDef.toArray(new Plato[0]));
        }
        return null;
    }
}

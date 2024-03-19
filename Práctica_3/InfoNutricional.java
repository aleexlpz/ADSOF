package Práctica_3;
import java.util.*;

public abstract class InfoNutricional {
    protected double calorias;
    protected double hidratos;
    protected double grasastotales;
    protected double grasassaturadas;
    protected double proteinas;
    protected double azucares;
    protected double fibra;
    protected double sodio;
    protected EnumSet<Alergeno> alergenos;

    public InfoNutricional(double calorias, double hidratos, double grasastotales, double grasassaturadas, double proteinas, double azucares, double fibra, double sodio) {
        this.calorias = calorias;
        this.hidratos = hidratos;
        this.grasastotales = grasastotales;
        this.grasassaturadas = grasassaturadas;
        this.proteinas = proteinas;
        this.azucares = azucares;
        this.fibra = fibra;
        this.sodio = sodio;
        this.alergenos = EnumSet.noneOf(Alergeno.class);
    }

    public double getCalorias() {
        return calorias;
    }

    public double getHidratos() {
        return hidratos;
    }

    public double getGrasasTotales() {
        return grasastotales;
    }

    public double getGrasasSaturadas() {
        return grasassaturadas;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getAzucares() {
        return azucares;
    }

    public double getFibra() {
        return fibra;
    }

    public double getSodio() {
        return sodio;
    }

    public EnumSet<Alergeno> getAlergenos() {
        return alergenos;
    }


    public InfoNutricional addInfoNutricional(InfoNutricional info, int cantidad){
        if (info instanceof  InfoNutricionalUnidad){
        this.calorias += info.getCalorias() * cantidad;
        this.hidratos += info.getHidratos() * cantidad;
        this.grasastotales += info.getGrasasTotales() * cantidad;
        this.grasassaturadas += info.getGrasasSaturadas() * cantidad;
        this.proteinas += info.getProteinas() * cantidad;
        this.azucares += info.getAzucares() * cantidad;
        this.fibra += info.getFibra() * cantidad;
        this.sodio += info.getSodio() * cantidad;
        }

        else if (info instanceof  InfoNutricionalPeso){
            this.calorias += (info.getCalorias() * cantidad)/100;
            this.hidratos += (info.getHidratos() * cantidad)/100;
            this.grasastotales += (info.getGrasasTotales() * cantidad)/100;
            this.grasassaturadas += (info.getGrasasSaturadas() * cantidad)/100;
            this.proteinas += (info.getProteinas() * cantidad)/100;
            this.azucares += (info.getAzucares() * cantidad)/100;
            this.fibra += (info.getFibra() * cantidad)/100;
            this.sodio += (info.getSodio() * cantidad)/100;

        }
        else if (info instanceof  InfoNutricionalPlato){
            this.calorias += info.getCalorias();
            this.hidratos += info.getHidratos();
            this.grasastotales += info.getGrasasTotales();
            this.grasassaturadas += info.getGrasasSaturadas();
            this.proteinas += info.getProteinas();
            this.azucares += info.getAzucares();
            this.fibra += info.getFibra();
            this.sodio += info.getSodio();
        }
        this.alergenos.addAll(info.getAlergenos());
            return this;
        }
        @Override
        public String toString() {
            return String.format(Locale.US,"Valor energetico: %.2f kcal, Hidratos de carbono: %.2f g, Grasas: %.2f g, Saturadas: %.2f g, Proteinas: %.2f g, Azucares: %.2f g, Fibra: %.2f g, Sodio: %.2f mg.",
                    this.calorias, this.hidratos, this.grasastotales, this.grasassaturadas, this.proteinas, this.azucares, this.fibra, this.sodio);
        }


}

package nubes.atlas.myclouds.model;

import java.util.Comparator;

public class Nuvol {

    private String nom;
    private String abrev;
    private String altura;
    private String precipitacio;
    private String descripcio;
    private String imatge;
    private String icono;

    public Nuvol(){}

    public static final Comparator<Nuvol> NomVulgar = new Comparator<Nuvol>() {
        @Override
        public int compare(Nuvol a1, Nuvol a2) {
            String nomVulgar1 = a1.getNom();
            String nomVulgar2 = a2.getNom();
            return nomVulgar1.compareTo(nomVulgar2);
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrecipitacio() {
        return precipitacio;
    }

    public void setPrecipitacio(String precipitacio) {
        this.precipitacio = precipitacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}

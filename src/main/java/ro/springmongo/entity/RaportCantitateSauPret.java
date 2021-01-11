package ro.springmongo.entity;

import java.text.DecimalFormat;

public class RaportCantitateSauPret {

    private String denComerciala;
    private String producator;
    private String pret;
    private String cantitate;
    private String valoare;

    public String getDenComerciala() {
        return denComerciala;
    }

    public void setDenComerciala(String denComerciala) {
        this.denComerciala = denComerciala;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public String getValoare() {
        double value = Double.parseDouble(valoare);
        return String.format("%.2f", value);
    }

    public void setValoare(String valoare) {
        this.valoare = valoare;
    }
}

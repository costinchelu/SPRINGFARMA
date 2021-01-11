package ro.springmongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static ro.springmongo.util.DateUtils.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Document(collection = "produse")
public class Produs {

    @Id
    private String id;

    @Field(name = "denComerciala")
    private String denComerciala;

    @Field(name = "concentratie")
    private String concentratie;

    @Field(name = "producator")
    private String producator;

    @Field(name = "pret")
    private double pret;

    @Field(name = "cantitate")
    private int cantitate;

    @Field(name = "bbd")
    private Date bbd;

    @Field(name = "dci")
    private Dci dci;

    @Field(name = "indicatii")
    private List<String> indicatii;

    private String bbdStr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDenComerciala() {
        if (denComerciala != null) {
            return denComerciala;
        } else {
            return "";
        }
    }

    public void setDenComerciala(String denComerciala) {
        this.denComerciala = denComerciala;
    }

    public String getConcentratie() {
        return concentratie;
    }

    public void setConcentratie(String concentratie) {
        this.concentratie = concentratie;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }


    // for editing
    public String getBbdStr() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(bbd != null) {
            return dateFormat.format(bbd);
        } else {
            return "";
        }
    }

    public void setBbdStr(String bbdStr) {
        this.bbd = stringToDate(bbdStr);
    }

    // normal get-set
    public Date getBbd() {
        return bbd;
    }

    // this will receive a string from the form (instead of a formed Date obj)
     public void setBbd(String dataString) {
        this.bbd = stringToDate(dataString);
    }

    // display in list
    public String getBbdString() {
        return dateToString(bbd);
    }

    // normal get-set
    public Dci getDci() {
        return dci;
    }

    public void setDci(Dci dci) {
        this.dci = dci;
    }

    // display in list
    public String getDciDenDci() {
        if(dci != null && dci.getDenDci() != null) {
            return dci.getDenDci();
        }
        return null;
    }

    public String getDciGrupaAtc() {
        if(dci != null && dci.getGrupaAtc() != null) {
            return dci.getGrupaAtc();
        }
        return null;
    }

    // normal get-set
    public List<String> getIndicatii() {
        return indicatii;
    }

    public void setIndicatii(List<String> indicatii) {
        this.indicatii = indicatii;
    }

    // display in list
    public String getIndicatiiEnumerate() {
        StringBuilder sb = new StringBuilder("");
        if (indicatii != null) {
            for(String p: indicatii) {
                sb.append(p).append(" ");
            }
        }
        return sb.toString();
    }
}

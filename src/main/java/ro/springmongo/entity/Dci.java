package ro.springmongo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Dci {

    @Field(name = "denDci")
    private String denDci;

    @Field(name = "grupaAtc")
    private String grupaAtc;



    public String getDenDci() {
        return denDci;
    }

    public void setDenDci(String denDci) {
        this.denDci = denDci;
    }

    public String getGrupaAtc() {
        return grupaAtc;
    }

    public void setGrupaAtc(String grupaAtc) {
        this.grupaAtc = grupaAtc;
    }
}

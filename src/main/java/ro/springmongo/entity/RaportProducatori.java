package ro.springmongo.entity;


import org.springframework.data.mongodb.core.mapping.Field;



public class RaportProducatori {

    @Field(name = "_id")
    private String producator;
    private double valoare;


    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }
}

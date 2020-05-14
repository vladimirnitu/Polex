package org.dxworks.hogwarts.metamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileCharacteristics {


    private String category;
    private String property;
    private Double value;

    public FileCharacteristics( String category , String property , Double value ) {

        this.category = category;
        this.property = property;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public Double getValue() {
        return value;
    }

    public boolean hasType( String type ) {
        return Objects.equals(type , this.category);
    }

    public String getRelationType() {
        return category;
    }



    @Override
    public String toString() {
        return "Relation {" +
                ", category = " + category +
                ", property = " + property +
                ", value = " + value +
                '}';
    }
}

package org.dxworks.hogwarts.metamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Relation {

    private List<Relation> relations = new ArrayList<>();
    private FileEntity entityType;
    private String category;
    private String property;
    private Double value;

    public Relation(FileEntity entityType, String category, String property, Double value) {
        this.entityType = entityType;
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

    public boolean hasType(String type) {
        return Objects.equals(type, this.category);
    }

    public String getRelationType() {
        return category;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void addRelation(Relation relation) {
        relations.add(relation);
    }

    @Override
    public String toString() {
        return "Relation {" +
                "entityType = " + entityType +
                ", category = " + category +
                ", property = " + property +
                ", value = " + value +
                '}';
    }
}

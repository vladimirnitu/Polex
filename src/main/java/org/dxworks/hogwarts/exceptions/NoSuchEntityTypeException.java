package org.dxworks.hogwarts.exceptions;

public class NoSuchEntityTypeException extends RuntimeException {
    private String entityType;

    public NoSuchEntityTypeException(String entityType) {
        super("Entity type " + entityType + " not found!");
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }
}

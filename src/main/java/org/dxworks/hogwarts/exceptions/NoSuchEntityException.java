package org.dxworks.hogwarts.exceptions;

public class NoSuchEntityException extends RuntimeException {
    private String entityType;
    private String entityId;

    public NoSuchEntityException(String entityType, String entityId) {
        super("Entity with id " + entityId + " for type " + entityType + " not found!");
        this.entityType = entityType;
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getEntityId() {
        return entityId;
    }
}

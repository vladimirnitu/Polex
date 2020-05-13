package org.dxworks.hogwarts.exceptions;

public class NoSuchRelationException extends RuntimeException {
    private String entityType;
    private String relationType;
    private String projectId;

    public NoSuchRelationException(String entityType, String relationType, String projectId) {
        super("Relation with type " + relationType + " was not found on entity type " + entityType + " on project with id " + projectId + "!");
        this.entityType = entityType;
        this.relationType = relationType;
        this.projectId = projectId;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getRelationType() {
        return relationType;
    }

    public String getProjectId() {
        return projectId;
    }
}

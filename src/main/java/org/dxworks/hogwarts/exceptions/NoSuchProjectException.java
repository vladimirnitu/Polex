package org.dxworks.hogwarts.exceptions;

public class NoSuchProjectException extends RuntimeException {
    private String projectId;

    public NoSuchProjectException(String projectId) {
        super("Project with id " + projectId + " not found!");
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }
}

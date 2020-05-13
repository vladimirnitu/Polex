package org.dxworks.hogwarts.service;

import org.dxworks.hogwarts.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> getAllProjects();
    void addFileContentToProject(String projectId, String content);
    ProjectDTO getById(String projectID);
}

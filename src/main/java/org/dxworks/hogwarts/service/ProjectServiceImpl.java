package org.dxworks.hogwarts.service;

import org.dxworks.hogwarts.dto.ProjectDTO;
import org.dxworks.hogwarts.model.ProjectEntity;
import org.dxworks.hogwarts.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> getAllProjects() {
        return ((List<ProjectEntity>) projectRepository.findAll()).stream()
                .map(this::convertProjectEntityToProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addFileContentToProject(String projectId, String content) {
        ProjectEntity projectById = projectRepository.getByProjectId(projectId);
        if (projectById == null) {
            projectById = new ProjectEntity();
            projectById.setProjectId(projectId);
        }
        List<String> fileContents = projectById.getFileContents();
        if (fileContents == null)
            fileContents = new ArrayList<>();

        fileContents.add(content);

        projectById.setFileContents(fileContents);
        projectRepository.save(projectById);
    }

    private ProjectDTO convertProjectEntityToProjectDTO(ProjectEntity projectEntity) {
        return ProjectDTO.builder().projectId(projectEntity.getProjectId())
                .build();
    }

    @Override
    public ProjectDTO getById(String projectId) {
        return this.convertProjectEntityToProjectDTO(projectRepository.getByProjectId(projectId));
    }
}

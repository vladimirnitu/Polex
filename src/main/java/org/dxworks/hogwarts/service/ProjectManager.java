package org.dxworks.hogwarts.service;

import com.google.gson.Gson;
import org.dxworks.hogwarts.exceptions.NoSuchProjectException;
import org.dxworks.hogwarts.metamodel.transformer.ProjectModel;
import org.dxworks.hogwarts.model.ProjectEntity;
import org.dxworks.hogwarts.parser.model.Config;
import org.dxworks.hogwarts.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectManager {

    @Autowired
    private ProjectRepository projectRepository;

    private Map<String, ProjectModel> projectsMap = new HashMap<>();

    public void addProject(String projectId, ProjectModel projectModel) {
        projectsMap.put(projectId, projectModel);
    }

    public ProjectModel getProjectModel(String projectId) {
        tryCreateProjectModelIfNotExistent(projectId);
        return Optional.ofNullable(projectsMap.get(projectId))
                .orElseThrow(() -> new NoSuchProjectException(projectId));
    }

    private void tryCreateProjectModelIfNotExistent(String projectId) {
        if (projectsMap.get(projectId) == null) {
            ProjectEntity projectEntity = projectRepository.getByProjectId(projectId);
            if (projectEntity != null) {
                createProjectModel(projectId, projectEntity);
            }
        }
    }

    private void createProjectModel(String projectId, ProjectEntity projectEntity) {
        Gson gson = new Gson();
        List<Config> configs = new ArrayList<>();
        for (Config c : configs) {
            c = gson.fromJson(projectEntity.getFileContents().get(0), Config.class);
            configs.add(c);
        }
        ProjectModel projectModel = new ProjectModel(configs);
        projectsMap.put(projectId, projectModel);
    }
}

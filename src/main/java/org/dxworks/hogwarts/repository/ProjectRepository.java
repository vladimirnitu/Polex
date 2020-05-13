package org.dxworks.hogwarts.repository;

import org.dxworks.hogwarts.model.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    ProjectEntity getByProjectId(String projectId);
}
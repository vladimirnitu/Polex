package org.dxworks.hogwarts.service;

import org.dxworks.hogwarts.dto.ComponentDTO;
import org.dxworks.hogwarts.model.CompEntity;
import org.dxworks.hogwarts.model.ProjectEntity;
import org.dxworks.hogwarts.repository.ComponentRepository;
import org.dxworks.hogwarts.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ComponentDTO> getAllComponents(String projectId) {
        ProjectEntity projectEntity = projectRepository.getByProjectId(projectId);

        return projectEntity.getComponents().stream()
                .map(this::convertCompEntityToComponentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addFileContentToComponent(String projectId, String content, String name) {

        ProjectEntity projectEntity = projectRepository.getByProjectId(projectId);

        CompEntity compEntity = new CompEntity();
        compEntity.setName(name);
        compEntity.setData(content);
        compEntity.setProject(projectEntity);

        componentRepository.save(compEntity);

        List<CompEntity> components = projectEntity.getComponents();
        components.add(compEntity);
        projectRepository.save(projectEntity);
    }

    @Override
    public ComponentDTO getById(String projectId, String name) {

        return this.convertCompEntityToComponentDTO(projectRepository.getByProjectId(projectId)
                .getComponents().stream().filter(compEntity -> compEntity.getName().equals(name)).findFirst().orElse(null));

    }

    private ComponentDTO convertCompEntityToComponentDTO(CompEntity compEntity) {
        return ComponentDTO.builder().componentName(compEntity.getName())
                .build();
    }

}

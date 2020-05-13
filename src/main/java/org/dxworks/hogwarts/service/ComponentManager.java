package org.dxworks.hogwarts.service;

import com.google.gson.Gson;
import org.dxworks.hogwarts.exceptions.NoSuchProjectException;
import org.dxworks.hogwarts.metamodel.transformer.ComponentModel;
import org.dxworks.hogwarts.model.CompEntity;
import org.dxworks.hogwarts.parser.model.ComponentConfig;
import org.dxworks.hogwarts.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComponentManager {

    @Autowired
    private ComponentRepository componentRepository;

    private Map<String, ComponentModel> componentsMap = new HashMap<>();

    @Override
    public String toString() {
        return "ComponentManager{" +
                "componentsMap=" + componentsMap +
                '}';
    }

    public void addProject(String componentSchemaName, ComponentModel componentModel) {
        componentsMap.put(componentSchemaName, componentModel);
    }

    public ComponentModel getComponentModel(String projectId) {
        tryCreateComponentModelIfNotExistent(projectId);
        return Optional.ofNullable(componentsMap.get(projectId))
                .orElseThrow(() -> new NoSuchProjectException(projectId));
    }

    private void tryCreateComponentModelIfNotExistent(String projectId) {
        if (componentsMap.get(projectId) == null) {
            CompEntity componentEntity = componentRepository.getByName(projectId);
            if (componentEntity != null) {
                createComponentModel(projectId, componentEntity);
            }
        }
    }

    private void createComponentModel(String projectId, CompEntity compEntity) {
        Gson gson = new Gson();
        List<ComponentConfig> configs = new ArrayList<>();

        for (ComponentConfig c : configs) {
            c = gson.fromJson(compEntity.getData(), ComponentConfig.class);
            configs.add(c);
        }
        ComponentModel componentModel = new ComponentModel(configs);
        componentsMap.put(projectId, componentModel);
    }
}

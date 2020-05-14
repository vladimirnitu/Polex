package org.dxworks.hogwarts.service;

import org.dxworks.hogwarts.metamodel.FileEntity;
import org.dxworks.hogwarts.metamodel.registries.ComponentRegistry;
import org.dxworks.hogwarts.metamodel.transformer.ComponentModel;
import org.dxworks.hogwarts.metamodel.transformer.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {
    @Autowired
   private ComponentManager componentManager;
    @Autowired
    private ProjectManager projectManager;

    public ArrayList<String> getAllFilesForSpecificComp(String componentSchemas, String componentName)
    {
        ComponentModel componentModel = componentManager.getComponentModel(componentSchemas);
        ComponentRegistry componentRegistry = componentModel.getComponentRegistry();
        return componentRegistry.getComponentOrPutIfNotExists(componentName).getFilesList();
    }

    public List<String> getAllFileNamesForASPECIFICCOMP(String projectNaME)
    {
        List<String> aux = new ArrayList<>();
        ProjectModel projectModel = projectManager.getProjectModel(projectNaME);
        return projectModel.getFileRegistry().getAllFileEntities().stream() .map(FileEntity::getName)
                .collect(Collectors.toList());

    }
}

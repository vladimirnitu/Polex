package org.dxworks.hogwarts.controllers;

import com.google.gson.Gson;
import org.dxworks.hogwarts.dto.ComponentDTO;
import org.dxworks.hogwarts.dto.ComponentViewDTO;
import org.dxworks.hogwarts.dto.ViewDTO;
import org.dxworks.hogwarts.metamodel.Component;
import org.dxworks.hogwarts.metamodel.ComponentSchema;
import org.dxworks.hogwarts.metamodel.registries.ComponentSchemaRegistry;
import org.dxworks.hogwarts.metamodel.transformer.ComponentModel;
import org.dxworks.hogwarts.metamodel.transformer.ProjectModel;
import org.dxworks.hogwarts.parser.model.ComponentConfig;
import org.dxworks.hogwarts.parser.model.Config;
import org.dxworks.hogwarts.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("create")
public class UploadController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ComponentService componentService;
    @Autowired
    private CompService compService;
    @Autowired
    private ProjectManager projectManager;
    @Autowired
    private ComponentManager componentManager;
    @Autowired
    private ComponentsRelationsService componentsRelationsService;
    @Autowired
    private ComponentSchemaRegistry componentSchemaRegistry;


    @PostMapping("/upload")
    public void uploadProject(@RequestParam("jsonFile") MultipartFile[] files, @RequestParam("projectId") String projectId) throws IOException {

        System.out.println(projectId);
        Gson gson = new Gson();
        List<Config> configs = new ArrayList<>();

        for (MultipartFile f : files) {
            String fileContent = String.join("\n", IOUtils.readLines(new InputStreamReader(f.getInputStream())));
            System.out.println(fileContent);

            projectService.addFileContentToProject(projectId, fileContent);

            Config c = gson.fromJson(new InputStreamReader(f.getInputStream()), Config.class);
            configs.add(c);
            System.out.println(c);

            ProjectModel projectModel = new ProjectModel(configs);
            projectManager.addProject(projectId, projectModel);
        }
    }
    // nu mai merge pe multiplu din cauza componentSchemaName
    @PostMapping("/uploadComponents")
    public void uploadComponent(@RequestParam("jsonFile") MultipartFile[] files, @RequestParam("projectId") String projectId, @RequestParam("name") String name) throws IOException {

        System.out.println(projectId);
        Gson gson = new Gson();
        List<ComponentConfig> componentConfigs = new ArrayList<>();

        for (MultipartFile f : files) {
            String fileContent = String.join("\n", IOUtils.readLines(new InputStreamReader(f.getInputStream())));
            System.out.println(fileContent);

            componentService.addFileContentToComponent(projectId, fileContent, name);

            ComponentConfig c = gson.fromJson(new InputStreamReader(f.getInputStream()), ComponentConfig.class);
            c.setComponentSchemasName(name);
            componentConfigs.add(c);
            System.out.println(c);

            ComponentModel componentModel = new ComponentModel(componentConfigs);
            componentManager.addProject(name, componentModel);
        }
    }

    @PostMapping("relation")
    public void createRelationProject(@RequestBody ComponentViewDTO body) {
        System.out.println(body);
    }

    @PostMapping("relationComponent")
    public void createRelationComponent(@RequestBody ComponentDTO body) {
        System.out.println(body);
    }

    @GetMapping("View1")
    public List<ViewDTO> getFirstView(@RequestParam("projectId") String projectId, @RequestParam("name") String name) {

        // componentsRelationsService.newCreatedComponent(projectId, name);
        List<String> componentNames = compService.getAllComponentNamesForComponentSchema(name);
        List<ViewDTO> viewDTOList = new ArrayList<>();

        for (String cn : componentNames) {
            viewDTOList.add(compService.getQAFromFile(projectId, cn, name));
            System.out.println(cn);
        }

        return viewDTOList;
    }

    @GetMapping("View2")
    public List<ViewDTO> getSecondView(@RequestParam("projectId") String projectId, @RequestParam("componentSchema") String name, @RequestParam("qualityAspect") String qa) {
        List<String> componentNames = compService.getAllComponentNamesForComponentSchema(name);
        List<ViewDTO> viewDTOList = new ArrayList<>();

        for (String cn : componentNames) {
            viewDTOList.add(compService.getQIForEachQA(projectId, cn, qa, name));
        }
        return viewDTOList;
    }
//
//    @GetMapping("Test2")
//    public Component getValueForQIController(@RequestParam("projectId") String pi, @RequestParam("comp") String comp) {
//
//
//        // return componentsRelationsService.getExtraFilesNotContainedByComponents(pi, comp);
//        return componentsRelationsService.newCreatedComponent(pi, comp);
//    }

//    @GetMapping("Test2")
//    public List<Double> getValueForQIController(@RequestParam("e") String entityTypeString, @RequestParam("r") String relationType, @RequestParam("p") String projectId, @RequestParam("qi") String qualityIndicator) {
//
//        return relationsService.getValueForQI(entityTypeString, relationType, projectId, qualityIndicator);
//    }

//    @GetMapping("Test2")
//    public Double getValuePerQualityIndicator(@RequestParam("p") String projectId, @RequestParam("c") String component, @RequestParam("qa") String qa, @RequestParam("qi") String qualityIndicator, @RequestParam("cs") String comp) {
//
//        return compService.getValuePerQualityIndicator(projectId, component, qa, qualityIndicator, comp);
//    }
}


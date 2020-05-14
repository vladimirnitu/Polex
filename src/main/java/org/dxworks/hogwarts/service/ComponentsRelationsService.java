//package org.dxworks.hogwarts.service;
//
//import org.dxworks.hogwarts.metamodel.Component;
//import org.dxworks.hogwarts.metamodel.registries.CompRelationRegistry;
//import org.dxworks.hogwarts.metamodel.transformer.ComponentModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class ComponentsRelationsService {
//
//    @Autowired
//    private ComponentManager componentManager;
//    @Autowired
//    private RelationsService relationsService;
//    @Autowired
//    private CompService compService;
//    @Autowired
//    private FileService fileService;
//    @Autowired
//    private ComponentSchemaRegistry componentSchemaRegistry;
//    @Autowired
//    private CompRelationRegistry compRelationRegistry;
//
//    public List<String> getRelationTypesForComponent(String component, String componentSchemaName) {
//        ComponentModel componentModel = componentManager.getComponentModel(componentSchemaName);
//        CompRelationRegistry relationRegistry = componentModel.getCompRelationRegistry();
//        ComponentSchemaRegistry componentSchemaRegistry = componentModel.getComponentSchemaRegistry();
//        ComponentSchema componentSchema = componentSchemaRegistry.getComponentEntity(component);
//
//        return relationRegistry.getRelationsForComponentEntity(componentSchema).stream()
//                .map(Component::getFilesList)
//                .collect(Collectors.toList()).get(0);
//    }
//
//    public List<String> getQualityAspectsForComponent(String componentSchemaName, String projectId) {
//
//        List<String> componentsFromComponentSchema = compService.getAllComponentNamesForComponentSchema(componentSchemaName);
//
//        List<String> qAForComponent = new ArrayList<>();
//
//        for(String c: componentsFromComponentSchema){
//            for (String fileFromComponent : getRelationTypesForComponent(c, componentSchemaName)){
//                qAForComponent.addAll(relationsService.getRelationTypesForEntity(fileFromComponent, projectId));
//            }
//        }
//        List<String> distinctQualityAspects = qAForComponent.stream().distinct().collect(Collectors.toList());
//
//        return distinctQualityAspects;
//    }
//
//    public ArrayList<String> getExtraFilesNotContainedByComponents(String projectId, String componentSchemaName){
//
//        List<String> allFilesFromComponents = new ArrayList<>();
//        List<String> filesFromProject = fileService.getAllFileNamesForProject(projectId);
//        List<String> componentsFromComponentSchema = compService.getAllComponentNamesForComponentSchema(componentSchemaName);
//
//        for(String cs: componentsFromComponentSchema)
//        {
//            for (String fileFromComponent : getRelationTypesForComponent(cs, componentSchemaName)) {
//                allFilesFromComponents.add(fileFromComponent);
//            }
//        }
//
//        ArrayList<String> union = new ArrayList<>(allFilesFromComponents);
//        union.addAll(filesFromProject);
//        ArrayList<String> intersection = new ArrayList<>(allFilesFromComponents);
//        intersection.retainAll(filesFromProject);
//        union.removeAll(intersection);
//
//        return union;
//    }
//
////    public void newCreatedComponent(String projectId, String componentSchemaName)
////    {
////        ComponentModel componentModel = componentManager.getComponentModel(componentSchemaName);
////        ArrayList<String> extraFiles = getExtraFilesNotContainedByComponents(projectId, componentSchemaName);
////        ComponentSchema newComponentSchema = componentModel.getComponentSchemaRegistry().getComponentEntity(componentSchemaName);
//////        ComponentSchema newComponentSchema = componentSchemaRegistry.getComponentEntityOrPutIfNotExists("@");
//////        newComponentSchema.addComponent(new ComponentSchema("@"));
////        List<Component> components = new ArrayList<>();
////        newComponentSchema.setName("@");
////        Component relation = componentModel.createNewRelation(newComponentSchema, extraFiles);
////        relation.addRelation(new Component(newComponentSchema, extraFiles));
////        compRelationRegistry.addRelation(relation, newComponentSchema);
////
////        for(ComponentSchema componentSchema: compRelationRegistry.getRelationTypeMap().keySet()) {
////         if(componentSchema.equals(newComponentSchema))
////
////        }
////        compRelationRegistry.getRelationTypeMap().put(newComponentSchema, extraFiles);
////    }
//}

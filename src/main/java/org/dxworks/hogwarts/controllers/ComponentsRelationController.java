//package org.dxworks.hogwarts.controllers;
//
////import org.dxworks.hogwarts.service.ComponentsRelationsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("compRelation")
//public class ComponentsRelationController {
//
//    @Autowired
//    private ComponentsRelationsService componentsRelationsService;
//
//    @GetMapping("compQualityAspects")
//    public List<String> getQualityAspectsForComponent(@RequestParam("name") String name, @RequestParam("projectId") String projectId) {
//        return componentsRelationsService.getQualityAspectsForComponent(name, projectId);
//    }
//
//
//}

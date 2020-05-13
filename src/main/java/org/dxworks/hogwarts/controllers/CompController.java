package org.dxworks.hogwarts.controllers;

import org.dxworks.hogwarts.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("component")
public class CompController {

//    @Autowired
//    private CompService componentService;
//
//    @GetMapping("names")
//    public List<String> getAllComponentNames(@RequestParam("projectId") String projectId) {
//        return componentService.getAllComponentNamesForProject(projectId);
//    }
}

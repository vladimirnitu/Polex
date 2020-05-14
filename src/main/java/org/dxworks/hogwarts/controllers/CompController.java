package org.dxworks.hogwarts.controllers;


import org.dxworks.hogwarts.service.ProjectService;
import org.dxworks.hogwarts.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("component")
public class CompController {

    @Autowired
    private TestService componentService;

//
//    @GetMapping("names")
//    public List<String> getAllComponentNames(@RequestParam("projectId") String projectId) {
//        return componentService.getAllComponentNamesForProject(projectId);
//    }
    @GetMapping("files")
    public ArrayList<String> getblabla(@RequestParam("comp") String comp, @RequestParam("name") String name)
    {
        return componentService.getAllFilesForSpecificComp(comp,name);
    }
    @GetMapping("files1")
    public List<String> getblabla1(@RequestParam("PR") String comp)
    {
        return componentService.getAllFileNamesForASPECIFICCOMP(comp);
    }

}

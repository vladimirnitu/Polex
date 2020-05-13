package org.dxworks.hogwarts.controllers;

import org.dxworks.hogwarts.dto.ComponentDTO;
import org.dxworks.hogwarts.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("components")
public class ComponentsController {

    @Autowired
    private ComponentService componentService;

    @GetMapping("/allComponents")
    public List<ComponentDTO> getAllComponents(@RequestParam("projectId") String projectId) {
        return componentService.getAllComponents(projectId);
    }

//    @PostMapping("/addComponents")
//    public void addComponent(@RequestBody ComponentDTO componentDTO) {
////     componentService.addProject(componentDTO);
//    }

    @GetMapping("/component")
    public ComponentDTO ComponentDTO(@RequestParam("projectId") String projectId, @RequestParam("name") String name) {
        return componentService.getById(projectId, name);
    }
}

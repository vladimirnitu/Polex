package org.dxworks.hogwarts.controllers;

import org.dxworks.hogwarts.dto.ProjectDTO;
import org.dxworks.hogwarts.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectsController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

//    @PostMapping("/add")
//    public void addProject(@RequestBody ProjectDTO projectDTO) {
////     projectService.addProject(projectDTO);
//    }

    @GetMapping("/project")
    public ProjectDTO getById(@RequestParam String projectId) {
        return projectService.getById(projectId);
    }

}

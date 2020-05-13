package org.dxworks.hogwarts.controllers;

import org.dxworks.hogwarts.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("names")
    public List<String> getAllFileNames(@RequestParam("projectId") String projectId) {
        return fileService.getAllFileNamesForProject(projectId);
    }
}
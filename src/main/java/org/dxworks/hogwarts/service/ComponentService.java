package org.dxworks.hogwarts.service;

import org.dxworks.hogwarts.dto.ComponentDTO;

import java.util.List;

public interface ComponentService {

    List<ComponentDTO> getAllComponents(String projectId);
    void addFileContentToComponent(String projectId, String content, String name);
    ComponentDTO getById(String projectId,String name);

}

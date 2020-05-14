package org.dxworks.hogwarts.metamodel.transformer;

import lombok.extern.slf4j.Slf4j;
import org.dxworks.hogwarts.metamodel.*;
import org.dxworks.hogwarts.metamodel.registries.FileRegistry;
import org.dxworks.hogwarts.parser.model.Config;
import org.dxworks.hogwarts.parser.model.FileModel;

import java.util.List;

@Slf4j
public class ProjectModel {

    private FileRegistry fileRegistry = new FileRegistry();


    public ProjectModel(List<Config> config) {
        for (Config c : config) {
            c.getFiles().forEach(fileModel -> {
                FileEntity fileEntity = fileRegistry.getFileEntityOrPutIfNotExists(fileModel.getFile());
                fileEntity.setFileCharacteristics(new FileCharacteristics(fileModel.getCategory(),fileModel.getName(),fileModel.getValue()));
                });
            };
        }





    public FileRegistry getFileRegistry() {
        return fileRegistry;
    }

}

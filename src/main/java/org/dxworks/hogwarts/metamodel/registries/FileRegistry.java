package org.dxworks.hogwarts.metamodel.registries;

import org.dxworks.hogwarts.exceptions.NoSuchEntityTypeException;
import org.dxworks.hogwarts.metamodel.FileEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FileRegistry {

    private Map<String, FileEntity> fileMap = new HashMap<String, FileEntity>();

    @Override
    public String toString() {
        return "File_registry {" +
                "FileMap = " + fileMap +
                '}';
    }

    public FileEntity getFileEntityOrPutIfNotExists(String type) {
        if (fileMap.containsKey(type))
            return fileMap.get(type);

        FileEntity newFileEntity = new FileEntity(type);
        fileMap.put(type, newFileEntity);
        return newFileEntity;
    }

    public FileEntity getFileEntity(String type) {
        return Optional.ofNullable(fileMap.get(type))
                .orElseThrow(() -> new NoSuchEntityTypeException(type));
    }

    public Collection<FileEntity> getAllFileEntities() {
        return fileMap.values();
    }

}




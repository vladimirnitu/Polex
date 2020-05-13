package org.dxworks.hogwarts.metamodel;

import java.util.HashMap;
import java.util.Map;

public class FileEntity {

    private String name;
    private Map<String, FileEntity> filesMap = new HashMap<>();

    public FileEntity(String file) {
        this.name = file;
    }

    public void addFile(FileEntity entity) {
        filesMap.put(entity.getName(), entity);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "name='" + name + '\'' +
                ", filesMap=" + filesMap +
                '}';
    }

}

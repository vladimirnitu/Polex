package org.dxworks.hogwarts.metamodel;

import java.util.*;

public class FileEntity {

    private String fileName;

    public FileCharacteristics getFileCharacteristics() {
        return fileCharacteristics;
    }

    public void setFileCharacteristics( FileCharacteristics fileCharacteristics ) {
        this.fileCharacteristics = fileCharacteristics;
    }

    private FileCharacteristics fileCharacteristics;

    public FileEntity(String file) {
        this.fileName = file;
    }



    public String getName() {
        return fileName;
    }
    public boolean hasName( String name ) {
        return Objects.equals(name , this.fileName);
    }


    @Override
    public String toString() {
        return "FileEntity{" +
                "name='" + fileName + '\'' +
                '}';
    }

}

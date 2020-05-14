package org.dxworks.hogwarts.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Component {


    private String name;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setFilesList( ArrayList<String> filesList ) {
        this.filesList = filesList;
    }

    private ArrayList<String> filesList;

    public Component( String name) {
        this.name = name;

    }

    public ArrayList<String> getFilesList() {
        return filesList;
    }

    public void addFile(String filename) {
        filesList.add(filename);
    }

    @Override
    public String toString() {
        return "Component{" +
                ", filesList=" + filesList +
                '}';
    }
}

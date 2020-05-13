package org.dxworks.hogwarts.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Component {

    private List<Component> components = new ArrayList<>();
    private ComponentSchema componentSchema;
    private ArrayList<String> filesList;

    public Component(ComponentSchema componentSchema, ArrayList<String> filesList) {
        this.componentSchema = componentSchema;
        this.filesList = filesList;
    }

    public ArrayList<String> getFilesList() {
        return filesList;
    }

    public void addRelation(Component relation) {
        components.add(relation);
    }

    @Override
    public String toString() {
        return "Component{" +
                "componentSchema=" + componentSchema +
                ", filesList=" + filesList +
                '}';
    }
}

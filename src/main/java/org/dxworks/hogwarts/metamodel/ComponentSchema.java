package org.dxworks.hogwarts.metamodel;

import java.util.HashMap;
import java.util.Map;

public class ComponentSchema {

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Map<String, ComponentSchema> componentsMap = new HashMap<>();

    public Map<String, ComponentSchema> getComponentsMap() {
        return componentsMap;
    }

    public ComponentSchema(String componentName) {
        this.name = componentName;
    }

    public void addComponent(ComponentSchema componentSchema) {
        componentsMap.put(componentSchema.getName(), componentSchema);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ComponentSchema{" +
                "name='" + name + '\'' +
                ", componentsMap=" + componentsMap +
                '}';
    }
}

package org.dxworks.hogwarts.metamodel.registries;

import org.dxworks.hogwarts.exceptions.NoSuchEntityTypeException;
import org.dxworks.hogwarts.metamodel.ComponentSchema;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ComponentSchemaRegistry {

    private Map<String, ComponentSchema> componentMap = new HashMap<>();

    @Override
    public String toString() {
        return "Component_registry {" +
                "ComponentMap = " + componentMap +
                '}';
    }

    public ComponentSchema getComponentEntityOrPutIfNotExists(String type) {
        if (componentMap.containsKey(type))
            return componentMap.get(type);

        ComponentSchema newComponentSchema = new ComponentSchema(type);
        componentMap.put(type, newComponentSchema);
        return newComponentSchema;
    }

    public ComponentSchema getComponentEntity(String type) {
        return Optional.ofNullable(componentMap.get(type))
                .orElseThrow(() -> new NoSuchEntityTypeException(type));
    }

    public Collection<ComponentSchema> getAllComponentEntities() {
        return componentMap.values();
    }
}

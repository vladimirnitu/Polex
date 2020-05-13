package org.dxworks.hogwarts.metamodel.registries;
import org.dxworks.hogwarts.metamodel.Component;
import org.dxworks.hogwarts.metamodel.ComponentSchema;

import java.util.*;

@org.springframework.stereotype.Component
public class CompRelationRegistry {

    public Map<ComponentSchema, List<Component>> getRelationTypeMap() {
        return relationTypeMap;
    }

    private Map<ComponentSchema, List<Component>> relationTypeMap = new HashMap<>();

    @Override
    public String toString() {
        return "Component_Relation_Registry {" +
                "relationTypeMap = " + relationTypeMap +
                '}';
    }

    public List<Component> getRelationsForComponentEntity(ComponentSchema type) {
        if (relationTypeMap.containsKey(type))
            return relationTypeMap.get(type);

        return Collections.emptyList();
    }

    public void addRelation(Component relation, ComponentSchema componentSchema) {
        List<Component> relations = relationTypeMap.get(componentSchema);
        if (relations == null)
            relations = new ArrayList<>();

        relations.add(relation);
        relationTypeMap.put(componentSchema, relations);
    }
}

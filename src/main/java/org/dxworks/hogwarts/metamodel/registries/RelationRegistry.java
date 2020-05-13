package org.dxworks.hogwarts.metamodel.registries;

import org.dxworks.hogwarts.metamodel.FileEntity;
import org.dxworks.hogwarts.metamodel.Relation;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RelationRegistry {
    private Map<FileEntity, List<Relation>> relationTypeMap = new HashMap<>();

    @Override
    public String toString() {
        return "Relation_Registry {" +
                "relationTypeMap = " + relationTypeMap +
                '}';
    }

    public List<Relation> getRelationsForFileEntity(FileEntity type) {
        if (relationTypeMap.containsKey(type))
            return relationTypeMap.get(type);

        return Collections.emptyList();
    }

    public Optional<Relation> getRelationForFileEntityAndCategoryType(FileEntity fileEntity, String categoryType) {
        return getRelationsForFileEntity(fileEntity).stream()
                .filter(relation -> relation.hasType(categoryType))
                .findFirst();
    }

    public void addRelation(Relation relation, FileEntity fileEntity) {
        List<Relation> relations = relationTypeMap.get(fileEntity);
        if (relations == null)
            relations = new ArrayList<>();

        relations.add(relation);
        relationTypeMap.put(fileEntity, relations);
    }

}
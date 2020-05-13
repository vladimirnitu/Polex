package org.dxworks.hogwarts.metamodel.transformer;

import lombok.extern.slf4j.Slf4j;
import org.dxworks.hogwarts.metamodel.*;
import org.dxworks.hogwarts.metamodel.registries.CompRelationRegistry;
import org.dxworks.hogwarts.metamodel.registries.ComponentSchemaRegistry;
import org.dxworks.hogwarts.parser.model.CompModel;
import org.dxworks.hogwarts.parser.model.ComponentConfig;


import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ComponentModel {

    private ComponentSchemaRegistry componentSchemaRegistry = new ComponentSchemaRegistry();
    private CompRelationRegistry compRelationRegistry = new CompRelationRegistry();

    public ComponentModel(List<ComponentConfig> config) {
        for (ComponentConfig c : config) {
            c.getComponents().forEach(compModel -> {
                try {
                    addRelation(compModel);
                } catch (RuntimeException e) {
                    log.error("Error creating relation " + compModel, e);
                }
            });
        }
    }

    private void addRelation(CompModel compModel) {

        ComponentSchema componentSchema = componentSchemaRegistry.getComponentEntityOrPutIfNotExists(compModel.getComponentName());
        componentSchema.addComponent(new ComponentSchema(compModel.getComponentName()));

        ArrayList<String> filesList = compModel.getFiles();
        Component relation = createNewRelation(componentSchema, filesList);
        relation.addRelation(new Component(componentSchema, filesList));
    }

    public ComponentSchemaRegistry getComponentSchemaRegistry() {
        return componentSchemaRegistry;
    }

    public CompRelationRegistry getCompRelationRegistry() {
        return compRelationRegistry;
    }

    public Component createNewRelation(ComponentSchema componentSchema, ArrayList<String> filesList) {
        Component r = new Component(componentSchema, filesList);
        compRelationRegistry.addRelation(r, componentSchema);
        return r;
    }
}
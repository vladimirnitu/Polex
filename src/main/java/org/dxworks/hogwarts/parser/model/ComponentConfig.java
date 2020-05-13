package org.dxworks.hogwarts.parser.model;


import lombok.Data;

import java.util.List;

@Data
public class ComponentConfig {
    private String componentSchemasName;
    private List<CompModel> components;
}

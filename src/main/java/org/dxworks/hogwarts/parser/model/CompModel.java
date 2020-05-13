package org.dxworks.hogwarts.parser.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CompModel {
    private String componentName;
    private ArrayList<String> files;
}
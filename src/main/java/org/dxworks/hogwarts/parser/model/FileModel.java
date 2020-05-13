package org.dxworks.hogwarts.parser.model;

import lombok.Data;

@Data
public class FileModel {
    private String name;
    private String category;
    private String file;
    private double value;
}
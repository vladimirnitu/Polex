package org.dxworks.hogwarts.parser.model;


import lombok.Data;

import java.util.List;

@Data
public class Config {
    private String projectId;
    private List<FileModel> files;
}

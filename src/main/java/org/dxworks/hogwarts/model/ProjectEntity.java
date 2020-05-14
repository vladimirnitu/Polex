package org.dxworks.hogwarts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects1")
public class ProjectEntity extends BaseEntity {

    @Column(unique = true)
    private String projectId;

    @Column(length = Integer.MAX_VALUE)
    @ElementCollection(targetClass = String.class)
    private List<String> fileContents;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            mappedBy = "project")
    private List<CompEntity> components;
}

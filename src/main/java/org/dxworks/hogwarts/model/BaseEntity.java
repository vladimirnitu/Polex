package org.dxworks.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    @NonNull
    protected Long id;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    protected Date lastModifiedDate;
    @CreatedDate
    @Column(name = "created_date")
    @JsonIgnore
    protected Date createdDate;
    @Version
    @Column(name = "version")
    private Long version;

}

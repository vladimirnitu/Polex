package org.dxworks.hogwarts.repository;

import org.dxworks.hogwarts.model.CompEntity;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<CompEntity, Long> {

    CompEntity getByName(String name);
}

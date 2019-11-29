package com.freenow.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.freenow.domainobject.ManufacturerDO;

/**
 * Database Access Object for manufacturer table.
 * <p/>
 */
@Repository
public interface ManufacturerRepository extends CrudRepository<ManufacturerDO, Long>{

	ManufacturerDO findByName(String name);

}

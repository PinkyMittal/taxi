package com.freenow.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.freenow.domainobject.CarDO;

/**
 * Database Access Object for car table.
 * <p/>
 */
@Repository
public interface CarRepository extends CrudRepository<CarDO, Long>
{

  
}

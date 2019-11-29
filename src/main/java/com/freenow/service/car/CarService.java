package com.freenow.service.car;

import java.math.BigDecimal;
import java.util.List;

import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;



public interface CarService {
	
	CarDO find(final Long carId) throws EntityNotFoundException;


    List<CarDO> findAllCars();


    CarDO create(final CarDO car) throws ConstraintsViolationException, EntityNotFoundException;


    void updateRating(long carId, BigDecimal rating)throws EntityNotFoundException;


    void delete(final Long carId) throws EntityNotFoundException;

}

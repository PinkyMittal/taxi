package com.freenow.service.driver;

import java.util.List;
import java.util.Map;

import com.freenow.datatransferobject.DriverDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.OnlineStatus;
import com.freenow.exception.CarAlreadyInUseException;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.exception.UserNotAvailable;

public interface DriverService
{

    DriverDO find(Long driverId) throws EntityNotFoundException;

    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;

    void delete(Long driverId) throws EntityNotFoundException;

    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;

    List<DriverDO> find(OnlineStatus onlineStatus);

	DriverDO selectCar(DriverDO driverDO, CarDO carDO) throws EntityNotFoundException, CarAlreadyInUseException, UserNotAvailable;

	DriverDO deSelectCar(DriverDO driverDO, CarDO carDO) throws EntityNotFoundException, CarAlreadyInUseException ;

	List<DriverDTO> findDriversByParams(Map<String, String> request);
    
}

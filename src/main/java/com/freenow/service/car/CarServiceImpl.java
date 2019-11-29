package com.freenow.service.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freenow.dataaccessobject.CarRepository;
import com.freenow.dataaccessobject.ManufacturerRepository;
import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.domainobject.ManufacturerDO;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository CarRepository;
	
	@Autowired
    private ManufacturerRepository manufacturerRepository;


	

	@Override
	public CarDO find(Long carId) throws EntityNotFoundException {

		return findCar(carId);
	}

	@Override
	public List<CarDO> findAllCars() {

		List<CarDO> allCars = new ArrayList<>();
		Iterable<CarDO> it = CarRepository.findAll();
		it.forEach(allCars::add);
		return allCars;
	}

	@Override
	public CarDO create(CarDO car) throws ConstraintsViolationException, EntityNotFoundException {

		return CarRepository.save(car);

	}


	@Override
	public void delete(Long carId) throws EntityNotFoundException {
		CarDO car = findCar(carId);
		car.setDeleted(Boolean.TRUE);

	}

	private CarDO findCar(Long carId) throws EntityNotFoundException {
		return CarRepository.findById(carId)
				.orElseThrow(() -> new EntityNotFoundException("Car with " + carId + " is not found"));
	}

	@Override
	public void updateRating(long carId, BigDecimal rating) throws EntityNotFoundException {
		CarDO carDO=findCar(carId);
		carDO.setRating(rating);
		
	}

	

}

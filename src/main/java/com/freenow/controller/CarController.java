package com.freenow.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.freenow.controller.mapper.CarMapper;
import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.service.car.CarService;


/**
 * All operations with a car will be routed by this controller.
 * @author Pinky
 * <p/>
 */
@RestController
@RequestMapping("v1/cars")
public class CarController {

	  private final CarService carService;


	    @Autowired
	    public CarController(final CarService carService)
	    {
	        this.carService = carService;
	    }


	@GetMapping(value = "/{carId}")
	public CarDTO getCar(@PathVariable long carId) throws EntityNotFoundException {

		return CarMapper.makeCarDTO(carService.find(carId));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CarDTO> getAllCars() {

		return CarMapper.makeCarDTOList(carService.findAllCars());
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CarDTO createCar(@Valid @RequestBody CarDTO carData) throws ConstraintsViolationException, EntityNotFoundException {
		CarDO carDO = CarMapper.makeCarDO(carData);
		return CarMapper.makeCarDTO(carService.create(carDO));
	}

	@DeleteMapping("/{carId}")
	public void deleteCar(@PathVariable long carId) throws EntityNotFoundException {
		carService.delete(carId);
	}

	 @PutMapping("/{carId}")
	 public void updateRating(
	        @Valid @PathVariable long carId, @RequestParam BigDecimal rating)
	        throws ConstraintsViolationException, EntityNotFoundException
	    {
	        carService.updateRating(carId, rating);
	    }
	 
	 
	   
}

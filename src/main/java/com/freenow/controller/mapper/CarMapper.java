package com.freenow.controller.mapper;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;

public class CarMapper {
	
	  public static CarDO makeCarDO(CarDTO carDTO)
	    {
		 
	        return new CarDO(carDTO.getId(), carDTO.getLicensePlate(), carDTO.getSeatCount(), 
	        		carDTO.getConvertible(), carDTO.getRating(), carDTO.getEngineType(), carDTO.getDeleted(),
	        		carDTO.getCarStatus(), carDTO.getManufacturer());
	    }

	public static CarDTO makeCarDTO(CarDO carDO) {

		 CarDTO.CarDTOBuilder carDTOBuilder = CarDTO
				 .newBuilder()
	                .setId(carDO.getId())
	                .setRating(carDO.getRating())
	                .setEngineType(carDO.getEngineType())
	                .setLicensePlate(carDO.getLicensePlate())
	                .setSeatCount(carDO.getSeatCount())
	                .setConvertible(carDO.getConvertible())
	                .setManufacturer(carDO.getManufacturer())
	                .setCarStatus(carDO.getCarStatus())
	                .setDeleted(carDO.getDeleted());

		        return carDTOBuilder.createCarDTO();
	}

	public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars) {
		return cars.stream().map(CarMapper::makeCarDTO).collect(Collectors.toList());
	}
	

    public static CarDTO convertParamsToDto(Map<String, String> searchParams)
    {
    	
        CarDTO.CarDTOBuilder carDTOBuilder =
            CarDTO
                .newBuilder()
                .setRating(new BigDecimal(searchParams.get("rating")))
                .setLicensePlate(searchParams.get("license"));
              
        return carDTOBuilder.createCarDTO();
    }



}

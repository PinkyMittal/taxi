package com.freenow.datatransferobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freenow.domainvalue.CarStatus;
import com.freenow.domainvalue.EngineType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

	@JsonIgnore
	private Long id;

	@NotNull(message = "licensePlate can not be null!")
	private String licensePlate;

	@NotNull(message = "seatCount can not be null!")
	private Integer seatCount;

	private Boolean convertible;

	private BigDecimal rating;

	@NotNull(message = "engineType can be either gas/electricity/disel !")
	private EngineType engineType;

	@NotNull(message = "manufacturer can not be null!")
	private String manufacturer;

	@Column(nullable = false)
	private Boolean deleted = false;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CarStatus carStatus;

	public CarDTO() {

	}

	public CarDTO(Long id, String licensePlate, Integer seatCount, Boolean convertible, BigDecimal rating,
			EngineType engineType, String manufacturer, Boolean deleted, CarStatus carStatus) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.rating = rating;
		this.engineType = engineType;
		this.manufacturer = manufacturer;
		this.deleted = deleted;
		this.carStatus = carStatus;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public Boolean getConvertible() {
		return convertible;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public CarStatus getCarStatus() {
		return carStatus;
	}

	public static CarDTOBuilder newBuilder() {
		return new CarDTOBuilder();
	}

	public static class CarDTOBuilder {

		private Long id;
		private String licensePlate;
		private Integer seatCount;
		private Boolean convertible;
		private BigDecimal rating;
		private EngineType engineType;
		private String manufacturer;
		private Boolean deleted = false;
		private CarStatus carStatus;

		public CarDTOBuilder setDeleted(Boolean deleted) {
			this.deleted = deleted;
			return this;
		}

		public CarDTOBuilder setCarStatus(CarStatus carStatus) {
			this.carStatus = carStatus;
			return this;
		}

		

		public CarDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public CarDTOBuilder setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
			return this;
		}

		public CarDTOBuilder setSeatCount(Integer seatCount) {
			this.seatCount = seatCount;
			return this;
		}

		public CarDTOBuilder setConvertible(Boolean convertible) {
			this.convertible = convertible;
			return this;
		}

		public CarDTOBuilder setRating(BigDecimal rating) {
			this.rating = rating;
			return this;
		}

		public CarDTOBuilder setEngineType(EngineType engineType) {
			this.engineType = engineType;
			return this;
		}

		public CarDTOBuilder setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}

		public CarDTO createCarDTO() {
			return new CarDTO(id, licensePlate, seatCount, convertible, rating, engineType, manufacturer, deleted, carStatus);
		}

	}

}

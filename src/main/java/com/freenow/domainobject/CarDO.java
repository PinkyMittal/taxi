package com.freenow.domainobject;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.freenow.domainvalue.CarStatus;
import com.freenow.domainvalue.EngineType;

@Entity
@Table(name = "car")
public class CarDO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@Column(nullable = false)
	private String licensePlate;

	@Column(nullable = false)
	private Integer seatCount;

	@Column
	private Boolean convertible;

	@Column
	private BigDecimal rating;
    
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EngineType engineType;

	@Column(nullable = false)
	private Boolean deleted = false;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CarStatus carStatus;

	
	@Column(nullable = false)
	private String manufacturer;
	
	

	public CarDO() {
	}

	

	public CarDO(Long id, String licensePlate, Integer seatCount, Boolean convertible,
			BigDecimal rating, EngineType engineType, Boolean deleted, CarStatus carStatus, String manufacturer) {
		super();
		this.id = id;
		
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.rating = rating;
		this.engineType = engineType;
		this.deleted = deleted;
		this.carStatus = carStatus;
		this.manufacturer = manufacturer;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public Boolean getConvertible() {
		return convertible;
	}

	public void setConvertible(Boolean convertible) {
		this.convertible = convertible;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	

	public CarStatus getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(CarStatus carStatus) {
		this.carStatus = carStatus;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "CarDO [id=" + id + ", dateCreated=" + dateCreated + ", licensePlate=" + licensePlate + ", seatCount="
				+ seatCount + ", convertible=" + convertible + ", rating=" + rating + ", engineType=" + engineType
				+ ", deleted=" + deleted + ", manufacturer=" + manufacturer + "]";
	}

}

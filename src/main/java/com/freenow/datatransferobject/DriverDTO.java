package com.freenow.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.freenow.domainvalue.GeoCoordinate;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDTO implements Comparable<DriverDTO>
{
    @JsonIgnore
    private Long id;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;

    private GeoCoordinate coordinate;

    private CarDTO carDTO;
    
   



	private DriverDTO()
    {
    }


    private DriverDTO(Long id, String username, String password, GeoCoordinate coordinate, CarDTO carDTO)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coordinate = coordinate;
        this.carDTO=carDTO;
    }


    public static DriverDTOBuilder newBuilder()
    {
        return new DriverDTOBuilder();
    }


    @JsonProperty
    public Long getId()
    {
        return id;
    }


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public GeoCoordinate getCoordinate()
    {
        return coordinate;
    }
    
    public CarDTO getCarDTO() {
		return carDTO;
	}

    public static class DriverDTOBuilder
    {
        private Long id;
        private String username;
        private String password;
        private GeoCoordinate coordinate;
        private CarDTO carDTO;

        public DriverDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public DriverDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public DriverDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }


        public DriverDTOBuilder setCoordinate(GeoCoordinate coordinate)
        {
            this.coordinate = coordinate;
            return this;
        }
        public DriverDTOBuilder setCarDTO(CarDTO carDTO) {
			this.carDTO = carDTO;
			return this;
		}


        public DriverDTO createDriverDTO()
        {
            return new DriverDTO(id, username, password, coordinate,carDTO);
        }

    }

	@Override
	public int compareTo(DriverDTO o) {
		// TODO Auto-generated method stub
		if(this.id==o.id)
			return 0;
		else if(this.id<o.id)
			return -1;
		else
			return 1;
	}
}

package com.minchu.incampus.transportation.locationmanagement.model.response;

import lombok.Data;

@Data
public class PairedVehiclesDetails{
	
	private String vehicleid;
	private String vehicletype;
	private String locaton[];

}

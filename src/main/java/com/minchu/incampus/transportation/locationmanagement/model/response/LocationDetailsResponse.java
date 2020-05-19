package com.minchu.incampus.transportation.locationmanagement.model.response;

import java.util.List; 

import lombok.Data;

@Data
public class LocationDetailsResponse implements VehicleLocationDetailsResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 727061874447939933L;
	
	public List<PairedVehiclesDetails> vehicleLocationDetails;

}

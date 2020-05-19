package com.minchu.incampus.transportation.locationmanagement.model.response;

import java.util.List;

import com.minchu.incampus.transportation.locationmanagement.model.views.BusLocationDetailsView;

import lombok.Data;

@Data
public class BusLocationDetailsResponse implements VehicleLocationDetailsResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 727061874447939933L;

	List<BusLocationDetailsView> busLocationDetails;

}

package com.minchu.incampus.transportation.locationmanagement.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonView;
import com.minchu.incampus.transportation.locationmanagement.model.Views;
import com.minchu.incampus.transportation.locationmanagement.model.request.Location;
import com.minchu.incampus.transportation.locationmanagement.model.response.EvGpsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.minchu.incampus.transportation.locationmanagement.model.dto.LocationDetailsDTO;
import com.minchu.incampus.transportation.locationmanagement.model.response.VehicleLocationDetailsResponse;
import com.minchu.incampus.transportation.locationmanagement.services.LocationDetailsService;
import com.minchu.incampus.transportation.locationmanagement.services.LocationReteriveService;

import java.security.Principal;
import java.util.List;

@RestController
public class LocationsControllerImpl implements LocationController{
	
	//Asset types validation
	public static final String ASSET_TYPE_VALIDATION="(bus|bicycle|scooter)";
	public static final String IS_SUCCESSFUL = "success";
	public static final String IS_NOT_SUCCESSFUL = "not success";
	
	private LocationDetailsService locationDetailsService;
	private LocationReteriveService locationReteriveService;

	@Autowired
	public LocationsControllerImpl(LocationDetailsService locationDetailsService,
			LocationReteriveService locationReteriveService) {
		this.locationDetailsService =locationDetailsService;
		this.locationReteriveService = locationReteriveService;
	}

	@Override
	public EvGpsResponse saveLocationDetails(@JsonView(Views.External.class) @Valid Location location, Principal principal) {
		LocationDetailsDTO locationDetailsDTO = locationDetailsService.createLocationDetails(location,principal.getName());
		EvGpsResponse evGpsResponse= new EvGpsResponse();
		if(!locationDetailsDTO.toString().isEmpty()){
			evGpsResponse.setSuccess(Boolean.TRUE);
		}else {
			 evGpsResponse.setSuccess(Boolean.FALSE);
		}
		return evGpsResponse;
	}

	@Override
	public VehicleLocationDetailsResponse getLocationDetails(@Pattern(regexp = ASSET_TYPE_VALIDATION) String assetType) {
		return locationReteriveService.getLocationDetails(assetType);
	}

	@Override
	public List<LocationDetailsDTO> getLatestLocation(int limit, Principal principal) {
		return locationReteriveService.getLatestLocation(limit,principal.getName());
	}

}

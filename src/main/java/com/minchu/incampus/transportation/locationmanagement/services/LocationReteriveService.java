package com.minchu.incampus.transportation.locationmanagement.services;

import java.util.List;

import com.minchu.incampus.transportation.locationmanagement.model.dto.LocationDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.minchu.incampus.transportation.locationmanagement.model.response.BusLocationDetailsResponse;
import com.minchu.incampus.transportation.locationmanagement.model.response.VehicleLocationDetailsResponse;
import com.minchu.incampus.transportation.locationmanagement.repository.BusLocationsRepository;
import com.minchu.incampus.transportation.locationmanagement.repository.LocationDetailsRepository;

@Service
public class LocationReteriveService {
	
	private BusLocationsRepository busLocationDetailsRepository;
	private LocationDetailsRepository locationDetailsRepository;
	
	@Autowired
	public LocationReteriveService(BusLocationsRepository busLocationDetailsRepository
			,LocationDetailsRepository locationDetailsRepository) {
		this.busLocationDetailsRepository = busLocationDetailsRepository;
		this.locationDetailsRepository = locationDetailsRepository;

	}

	public VehicleLocationDetailsResponse getLocationDetails(String assetType) {
		BusLocationDetailsResponse response = new BusLocationDetailsResponse();
		switch(assetType) {
			
			case "bus":
				 response.setBusLocationDetails(busLocationDetailsRepository.findAll());
				return response;
			case "bicycle":
				return null;
			case "scooter":
				return null;
	        default:
	            return null;
		}
	}
	
    public List<LocationDetailsDTO> getLatestLocation(int limit,String devId) {
		return locationDetailsRepository.findLatestLocations(devId,limit);
    }
}

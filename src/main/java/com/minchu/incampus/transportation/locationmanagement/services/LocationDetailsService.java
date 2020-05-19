package com.minchu.incampus.transportation.locationmanagement.services;

import java.text.SimpleDateFormat;

import com.minchu.incampus.transportation.locationmanagement.model.dto.EmbeddableLocation;
import com.minchu.incampus.transportation.locationmanagement.model.dto.GpsDevicekycDTO;
import com.minchu.incampus.transportation.locationmanagement.model.request.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minchu.incampus.transportation.locationmanagement.model.dto.LocationDetailsDTO;
import com.minchu.incampus.transportation.locationmanagement.repository.GpsDeviceRepository;
import com.minchu.incampus.transportation.locationmanagement.repository.LocationDetailsRepository;

@Service
public class LocationDetailsService {
	
	
	private LocationDetailsRepository locationDetailsRepository;
	private GpsDeviceRepository gpsDeviceRepository;
	
	@Autowired
	public LocationDetailsService(LocationDetailsRepository locationDetailsRepository,
			GpsDeviceRepository gpsDeviceRepository) {
		this.locationDetailsRepository = locationDetailsRepository;
		this.gpsDeviceRepository = gpsDeviceRepository;
	}
	
	public LocationDetailsDTO createLocationDetails(Location location,String serialNo) {
		
//		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
		System.out.println(location.getBatteryStatus());
		EmbeddableLocation loc = new EmbeddableLocation();
		
		loc.setIdgps(serialNo);
		loc.setTimestamp(location.getTimestamp());

		GpsDevicekycDTO gpsDevicekycDTO;
		gpsDevicekycDTO=gpsDeviceRepository.findBySerialNo(serialNo);
		gpsDevicekycDTO.setBatteryStatus(location.getBatteryStatus());
		gpsDeviceRepository.saveAndFlush(gpsDevicekycDTO);
		return locationDetailsRepository.save(LocationDetailsDTO.builder()
																.location(loc)
																.lattitude(location.getLattitude())
																.longitude(location.getLongitude())
																.build());
	}

}

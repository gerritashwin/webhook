package com.minchu.incampus.transportation.locationmanagement.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonView;
import com.minchu.incampus.transportation.locationmanagement.model.Views;
import com.minchu.incampus.transportation.locationmanagement.model.dto.LocationDetailsDTO;
import com.minchu.incampus.transportation.locationmanagement.model.request.Location;
import com.minchu.incampus.transportation.locationmanagement.model.response.EvGpsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minchu.incampus.transportation.locationmanagement.model.response.VehicleLocationDetailsResponse;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/v1.1/incampus/transportation")
public interface LocationController {
	
	//Asset types validation
	public static final String ASSET_TYPE_VALIDATION="(bus|bicycle|scooter)";
	
	@PostMapping("/vehicle/location")
	public EvGpsResponse saveLocationDetails(@JsonView(Views.External.class) @Valid @RequestBody Location location, Principal principal);

	@GetMapping("/vehicle/location")
	public VehicleLocationDetailsResponse getLocationDetails( @RequestParam(name = "type") @Pattern(regexp = ASSET_TYPE_VALIDATION) String AssetType);

	@GetMapping("/test/location")
	public List<LocationDetailsDTO> getLatestLocation(@RequestParam(name="limit") int limit,Principal principal);
}

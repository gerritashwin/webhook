package com.minchu.incampus.transportation.locationmanagement.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonView;
import com.minchu.incampus.transportation.locationmanagement.model.Views;
import lombok.Data;

@Data
public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 827862818252152740L;

	@JsonView(Views.Internal.class)
	@Pattern(regexp="^[0-9]+$")
	private String Id;
	@JsonView(Views.External.class)
	private float lattitude;
	@JsonView(Views.External.class)
	private float longitude;
	@JsonView(Views.External.class)
	private long timestamp;
	@JsonView(Views.External.class)
	private int batteryStatus;

}

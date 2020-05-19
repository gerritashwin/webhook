package com.minchu.incampus.transportation.locationmanagement.model.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class LocationDetailsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3192917678617101905L;
	
	@EmbeddedId
	@JsonUnwrapped
	private EmbeddableLocation location;
	private float lattitude;
	private float longitude;

}

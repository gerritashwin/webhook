package com.minchu.incampus.transportation.locationmanagement.model.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class EmbeddableBusLocationDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2471457027202830275L;
	private Double lattitude;
	private Double longitude;

}

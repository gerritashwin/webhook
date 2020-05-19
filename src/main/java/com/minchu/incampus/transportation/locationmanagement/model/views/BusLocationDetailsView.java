package com.minchu.incampus.transportation.locationmanagement.model.views;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.minchu.incampus.transportation.locationmanagement.model.dto.EmbeddableBusLocationDetails;

import lombok.Data;

@Data
@Entity
@Table(name="BusLocationDetailsView")
public class BusLocationDetailsView {
	
	@EmbeddedId
	private EmbeddableBusLocationDetails latLong;
	@Column(name="busId")
	private String busId;
	@Column(name="assetType")
	private String assetType;

}

package com.minchu.incampus.transportation.locationmanagement.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.minchu.incampus.transportation.locationmanagement.model.response.PacketResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus_kyc")
public class BusKycDTO implements PacketResponse{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8132776662051030594L;
	
	@Id
    @Column(name = "vehicle_Id")
    private String vehicle_Id;
    private int seatcapacity;

    private String approvedby;
    private String assetType;
}

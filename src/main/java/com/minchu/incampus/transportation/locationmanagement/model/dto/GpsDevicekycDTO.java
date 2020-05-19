package com.minchu.incampus.transportation.locationmanagement.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gpsdevice_kyc")
public class GpsDevicekycDTO {
	
    @Id
    @Column(name = "gpsdevice_kyc_serialno")
    private String serialNo;
    private int batteryStatus;
    private String approvedby;
    private String assetType;

}

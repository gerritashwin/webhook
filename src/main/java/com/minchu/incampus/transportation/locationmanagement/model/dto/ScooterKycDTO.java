package com.minchu.incampus.transportation.locationmanagement.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "scooter_kyc")
@NoArgsConstructor
@AllArgsConstructor
public class ScooterKycDTO {
	
    @Id
    private String vehicle_Id;
    private String battery_type;
    private String insurance_date;
    private String model_number;
    private String battery_Id;
    private String battery_warranty;
    private String make;
    private String chassis_number;
    private float max_range;

    private String approvedby;
    private String assetType;

}

package com.minchu.incampus.transportation.locationmanagement.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "bicycle_kyc")
@NoArgsConstructor
@AllArgsConstructor
public class BicycleKycDTO {
    @Id
    private String vehicle_Id;
    private String battery_type;
    private String battery_id;
    private String model;
    private String battery_warranty;
    private String make;
    private String assetType;

    private String approvedby;
}

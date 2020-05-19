package com.minchu.incampus.transportation.locationmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minchu.incampus.transportation.locationmanagement.model.dto.ScooterKycDTO;
import com.minchu.incampus.transportation.locationmanagement.model.projections.ScooterKycProjectionModel;

@Repository
public interface ScooterKycRepository extends JpaRepository<ScooterKycDTO,String>{

	@Query(value = "select  swg.idgps,s.vehicle_Id,s.assetType from scooter_kyc s right join scooter_with_gps swg on s.idscooter = swg.idscooter",nativeQuery = true)
    public List<ScooterKycProjectionModel> findAllPairedScooter();
}

package com.minchu.incampus.transportation.locationmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minchu.incampus.transportation.locationmanagement.model.dto.BicycleKycDTO;
import com.minchu.incampus.transportation.locationmanagement.model.projections.BicycleKycProjectionModel;

@Repository
public interface BicycleKycRepository extends JpaRepository<BicycleKycDTO,String> {

	@Query(value = "select  b.vehicle_Id,b.AssetType,bwg.idgps from bicycle_kyc b right join bicycle_with_gps bwg on b.idbicycle =bwg.idbicycle",nativeQuery = true)
    public List<BicycleKycProjectionModel> findAllPairedBicycles();
}

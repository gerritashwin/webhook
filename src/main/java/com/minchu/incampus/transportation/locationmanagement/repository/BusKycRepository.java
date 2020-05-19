package com.minchu.incampus.transportation.locationmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minchu.incampus.transportation.locationmanagement.model.dto.BusKycDTO;
import com.minchu.incampus.transportation.locationmanagement.model.projections.BusKycProjectionModel;

@Repository
public interface BusKycRepository extends JpaRepository<BusKycDTO, String>{

	@Query(value = "select st.vehicleid, st.assettype, gps.gpsdevice_kyc_serialno as idgps"
			+ " from gpsdevice_kyc gps join "
			+ "(select  b.vehicle_Id as vehicleid,b.AssetType as assettype,bwg.idgps as igps "
			+ "from bus_kyc b right join bus_with_gps bwg on b.idbus =bwg.idbus) st "
			+ "where gps.idgpsdevice = st.igps",nativeQuery = true)
    public List<BusKycProjectionModel> findAllPairedBuses();
	
}

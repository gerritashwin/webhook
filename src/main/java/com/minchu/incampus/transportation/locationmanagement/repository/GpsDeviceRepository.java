package com.minchu.incampus.transportation.locationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minchu.incampus.transportation.locationmanagement.model.dto.GpsDevicekycDTO;

@Repository
public interface GpsDeviceRepository extends JpaRepository<GpsDevicekycDTO,String>{
	
	@Query(value="SELECT idgpsdevice FROM gpsdevice_kyc where gpsdevice_kyc_serialno= ?1", nativeQuery=true)
	public String getGpsIdBySerialNo(String serialNo);

	GpsDevicekycDTO findBySerialNo(String serialNo);
}

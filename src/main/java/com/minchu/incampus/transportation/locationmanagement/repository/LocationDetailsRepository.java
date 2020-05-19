package com.minchu.incampus.transportation.locationmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minchu.incampus.transportation.locationmanagement.model.dto.LocationDetailsDTO;
import com.minchu.incampus.transportation.locationmanagement.model.projections.LocationDetailsProjectionModel;

@Repository
public interface LocationDetailsRepository  extends JpaRepository<LocationDetailsDTO,String>{

	
	@Query(value = "select  loc.lattitude, loc.longitude, loc.idgps from location loc where loc.idgps = ?1",nativeQuery = true)
    public List<LocationDetailsProjectionModel> findAllPairedBusLocations(String idfps);
	
	@Query(value = "select  loc.lattitude, loc.longitude, loc.idgps from scooter_with_gps b left join location loc on b.idgps = loc.idgps",nativeQuery = true)
    public List<LocationDetailsProjectionModel> findAllPairedScooterLocations();
	
	@Query(value = "select  loc.lattitude, loc.longitude, loc.idgps from bicycle_with_gps b left join location loc on b.idgps = loc.idgps",nativeQuery = true)
    public List<LocationDetailsProjectionModel> findAllPairedBicycleLocations();

	@Query(nativeQuery = true,value = "select * from location WHERE idgps=:devId order by timestamp DESC limit :limit ")
    List<LocationDetailsDTO> findLatestLocations(@Param("devId") String devId, @Param("limit") int limit);
}

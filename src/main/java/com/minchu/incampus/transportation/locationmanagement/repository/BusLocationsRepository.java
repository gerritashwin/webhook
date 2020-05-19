package com.minchu.incampus.transportation.locationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minchu.incampus.transportation.locationmanagement.model.views.BusLocationDetailsView;

@Repository
public interface BusLocationsRepository extends JpaRepository<BusLocationDetailsView, String>{

	
}

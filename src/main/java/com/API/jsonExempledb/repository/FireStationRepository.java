package com.API.jsonExempledb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.API.jsonExempledb.model.FireStation;


public interface FireStationRepository extends CrudRepository<FireStation, Long>{

	void removeByAddressAndStation(String address, String station);

	Iterable<FireStation> findAllByStation(String station);

	Optional<FireStation> findByAddressAllIgnoreCase(String address);

}

package com.API.jsonExempledb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.API.jsonExempledb.model.FireStation;
import com.API.jsonExempledb.service.FireStationService;


@RestController

public class FireStationController {

	private static final Logger logger = LogManager.getLogger(FireStationController.class);

	private FireStationService firestationService;

	public FireStationController(FireStationService firestationService) {
	        this.firestationService = firestationService;
	    }
	
	@GetMapping("/listfirestation")
    public Iterable<FireStation> list() {
        return firestationService.list();
    }
	
	/**
	 * Read - Get all fire stations
	 */

	@GetMapping("/firestation")
	public Iterable<FireStation> getFireStations() {

		return firestationService.getFireStations();
	}
	@PostMapping(value = "/firestation")
	public FireStation addPerson(@RequestBody FireStation firestation) throws Exception {
		logger.info("req Put endpoint 'firestation'");

		FireStation updatedFirestation = firestationService.addFirestation(firestation);
		if (updatedFirestation != null) {
			logger.info("req next Put endpoint 'firestation' ");
			return updatedFirestation;
		} else {
			throw new Exception("firestation.added.error");
		}
	}
	 @PutMapping("/firestation")
		public FireStation  updateAddressForFireStation(@RequestBody FireStation firestation) throws Exception {
			logger.info("req Put endpoint 'firestation'");

			FireStation updatedFirestation = firestationService.updateFireStation(firestation);
			if (updatedFirestation != null) {
				logger.info("req next Put endpoint 'firestation' ");
				return updatedFirestation;
			} else {
				throw new Exception("firestation.update.error");
			}
		}
	@DeleteMapping("/firestation")
	@Transactional
	public void deleteFireStation(@RequestBody FireStation firestation) {
		logger.info("Req Delete  endpoint 'firestation'");
		firestationService.deleteFirestation(firestation);

	}
}
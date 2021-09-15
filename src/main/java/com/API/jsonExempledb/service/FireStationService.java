package com.API.jsonExempledb.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.API.jsonExempledb.model.FireStation;

import com.API.jsonExempledb.repository.FireStationRepository;



@Service
public class FireStationService {
	
	private static final Logger logger = LogManager.getLogger(FireStationService.class);
	
	private FireStationRepository firestationRepository;

    public FireStationService(FireStationRepository firestationRepository) {
        this.firestationRepository = firestationRepository;
    }
    public Iterable<FireStation> list() {
        return firestationRepository.findAll();
    }
    public FireStation save(FireStation firestation){
        return firestationRepository.save(firestation);
    }
	public void save(List<FireStation> firestations) {
		firestationRepository.saveAll(firestations);
		
	}
	public Iterable<FireStation> getFireStations() {
		return firestationRepository.findAll();
	}
	/**
	 * add a fire station
	 * 
	 * @param firestation to add
	 * @return firestation added, or null object
	 * @throws Exception
	 */
	public FireStation addFirestation(FireStation firestation) throws Exception {
		try {
			firestationRepository.save(firestation);
		} catch (Exception exception) {

			throw new Exception("The fire station could not be added:" + exception.getMessage());
		}
		return firestation;
	}
	/**
     * update station number
     *
     * @param fireStation
     * @re4turn null if has a problem when updating
     * µ/*
     */
    public FireStation updateFireStation(FireStation fireStation) {
        if (fireStation != null) {
            Optional<FireStation> fireStationOptional = this.getFireStationByAddressIgnoreCase(fireStation.getAddress());

            if (fireStationOptional  .isPresent()) {
            	FireStation firestationToUpdate = fireStationOptional.get();

            	firestationToUpdate.setAddress(fireStation.getAddress());
            	firestationToUpdate.setStation(fireStation.getStation());
                    try {
                        firestationRepository.save(firestationToUpdate);
                    } catch (Exception exception) {
                        logger.error("error when updating Fire station:" + exception.getMessage() +
                                " Stack Trace : " + exception.getStackTrace());
                        return null;
                    }
                }
                return fireStation;
            }
		return fireStation;
        }

    private Optional<FireStation> getFireStationByAddressIgnoreCase(String address) {
		try {
			return firestationRepository.findByAddressAllIgnoreCase(address);
		} catch (Exception exception) {
			logger.error("Error while getting a firestation: " + exception.getMessage() + " Stack Trace + "
					+ exception.getStackTrace());
			return null;
		}
	}

	/**
	 * delete one person if exist
	 * 
	 * @param person to delete
	 * @return
	 * @return
	 */
	public FireStation deleteFirestation(FireStation firestation) {
		firestationRepository.removeByAddressAndStation(firestation.getAddress(), firestation.getStation());
		return firestation;
	}

	
	  public Iterable<FireStation> getFirestationsFromStationNumber(String station) {
	        return firestationRepository.findAllByStation(station);
	    }
}

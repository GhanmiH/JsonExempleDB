package com.API.jsonExempledb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.API.jsonExempledb.model.Allergies;
import com.API.jsonExempledb.repository.AllergieRepository;

@Service
public class AllergieService {

	private AllergieRepository allergieRepository;

    public AllergieService(AllergieRepository allergieRepository) {
        this.allergieRepository = allergieRepository;
    }
    public Iterable<Allergies> list() {
        return allergieRepository.findAll();
    }
    public Allergies save(Allergies allergie){
        return allergieRepository.save(allergie);
    }
	public void save(List<Allergies> allergie) {
		allergieRepository.saveAll(allergie);
		
	}

}

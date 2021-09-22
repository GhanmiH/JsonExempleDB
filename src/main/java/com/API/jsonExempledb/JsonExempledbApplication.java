package com.API.jsonExempledb;

import com.API.jsonExempledb.model.Allergies;
import com.API.jsonExempledb.model.FireStation;
import com.API.jsonExempledb.model.MedicalRecord;
import com.API.jsonExempledb.model.Medications;
import com.API.jsonExempledb.model.Person;
import com.API.jsonExempledb.service.AllergieService;
import com.API.jsonExempledb.service.FireStationService;
import com.API.jsonExempledb.service.MedicalRecordService;
import com.API.jsonExempledb.service.MedicationService;
import com.API.jsonExempledb.service.PersonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JsonExempledbApplication {
	 
	private static final Logger logger = LogManager.getLogger(JsonExempledbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JsonExempledbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PersonService personService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/person.json");
			try {
				List<Person> persons = mapper.readValue(inputStream, typeReference);
				personService.save(persons);
				System.out.println("Persons Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save persons: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runner1(FireStationService firestationService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<FireStation>> typeReference = new TypeReference<List<FireStation>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/firestation.json");
			try {
				List<FireStation> firestations = mapper.readValue(inputStream, typeReference);
				firestationService.save(firestations);
				System.out.println("Fire Stations Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save fire stations: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runner2(MedicalRecordService medicalrecordService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MedicalRecord>> typeReference = new TypeReference<List<MedicalRecord>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/medicalrecord.json");
			try {
				List<MedicalRecord> medicalrecords = mapper.readValue(inputStream, typeReference);
				medicalrecordService.save(medicalrecords);
				System.out.println("Medical Records Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save medical records: " + e.getMessage());
			}
		};
	}
	/*@Bean
	CommandLineRunner runner4(MedicationService medicationService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Medications>> typeReference = new TypeReference<List<Medications>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/medications.json");
			try {
				List<Medications> medications = mapper.readValue(inputStream, typeReference);
				medicationService.save(medications);
				System.out.println("Medications Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save medications: " + e.getMessage());
			}
		};
	}*/
	@Bean
	CommandLineRunner runner5(AllergieService allergieService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Allergies>> typeReference = new TypeReference<List<Allergies>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/allergies.json");
			try {
				List<Allergies> allergies = mapper.readValue(inputStream, typeReference);
				allergieService.save(allergies);
				System.out.println("Allergies Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save allergies: " + e.getMessage());
			}
		};
	}
	
}

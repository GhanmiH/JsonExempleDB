package com.API.jsonExempledb.model;

import lombok.Data;

import java.util.List;

@Data
public class JsonData {
    List<Person> persons;
    List<FireStation> firestations;
    List<MedicalRecord> medicalrecords;
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<FireStation> getFirestations() {
		return firestations;
	}
	public void setFirestations(List<FireStation> firestations) {
		this.firestations = firestations;
	}
	public List<MedicalRecord> getMedicalrecords() {
		return medicalrecords;
	}
	public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
	
}
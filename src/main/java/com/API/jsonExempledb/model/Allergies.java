package com.API.jsonExempledb.model;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@MappedSuperclass
@Entity
@Data
@AllArgsConstructor
@Embeddable
public class Allergies extends MedicalRecord{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@JsonProperty("allergie")
	
	private String allergie;

	public Allergies() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Allergies(Long id, String allergie) {
		super();
		this.id = id;
		this.allergie = allergie;
	}

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}

	@Override
	public String toString() {
		return "Allergies [id=" + id + ", allergie=" + allergie + "]";
	}
	
}
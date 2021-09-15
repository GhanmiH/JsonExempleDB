package com.API.jsonExempledb.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Allergies {


	@JsonProperty("allergie")
	@ElementCollection
	 private List<String> allergie;

	public Allergies() {
	}
}

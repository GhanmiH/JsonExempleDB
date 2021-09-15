package com.API.jsonExempledb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.API.jsonExempledb.JsonExempledbApplication;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class FireStation {

	private static final Logger logger = LogManager.getLogger(FireStation.class);
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @JsonProperty("id")
     private Long id;
	
	@JsonProperty("address")
    private String address;
    
    @JsonProperty("station")
    private String station;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "FireStation [id=" + id + ", address=" + address + ", station=" + station + "]";
	}
    
    
}

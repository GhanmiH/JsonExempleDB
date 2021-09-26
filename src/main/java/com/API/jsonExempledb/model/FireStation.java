package com.API.jsonExempledb.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireStation {

    private String address;
    private int station;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	
}
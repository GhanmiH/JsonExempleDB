package com.API.jsonExempledb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JsonExempledbApplication {
	 
	private static final Logger logger = LogManager.getLogger(JsonExempledbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JsonExempledbApplication.class, args);
	}
}

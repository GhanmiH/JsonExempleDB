package com.API.jsonExempledb.repository;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.CrudRepository;

import com.API.jsonExempledb.controller.PersonController;
import com.API.jsonExempledb.model.Person;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete


public interface PersonRepository extends  CrudRepository<Person, Long> {
	
	static final Logger logger = LogManager.getLogger(PersonController.class);

	void removeByFirstNameAndLastName(String firstName, String lastName);

	Optional<Person> findByFirstNameAndLastNameAllIgnoreCase(String firstname, String lastname);




}

package com.API.jsonExempledb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.jsonExempledb.model.Person;
import com.API.jsonExempledb.service.PersonService;

@RestController

public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class); 
	
	private PersonService personService;

	public PersonController(PersonService personService) {
	        this.personService = personService;
	    }
	
	@GetMapping("/person")
	public Iterable<Person> getAllPersons() {
		logger.info("req Get endpoint Person");
		Iterable<Person> personIterable = personService.getAllPersons();
		logger.info("req next Get endpoint Person");
		return personIterable;

	}
	@PostMapping(value = "/person")
	public Person addPerson(@RequestBody Person person) throws Exception {
		logger.info("req Put endpoint 'person'");

		Person updatedPerson = personService.addPerson(person);
		if (updatedPerson != null) {
			logger.info("req next Put endpoint 'person' ");
			return updatedPerson;
		} else {
			throw new Exception("person.added.error");
		}
	}
	
	@DeleteMapping("/person")
	@Transactional
	public void deletePerson(@RequestBody Person person) {
		logger.info("Req Delete  endpoint 'person'");
		personService.deletePerson(person);

	}

	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) throws Exception {
		logger.info("req Put endpoint 'person'");

		Person updatedPerson = personService.updatePerson(person);
		if (updatedPerson != null) {
			logger.info("req next Put endpoint 'person' ");
			return updatedPerson;
		} else {
			throw new Exception("person.update.error");
		}
	}
}
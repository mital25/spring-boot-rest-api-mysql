package com.example.PersonsREST;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonsController {

	@Autowired
	private PersonsService service;

	@GetMapping("/persons")
	public List<Persons> list() {
		return service.listAll();
	}

	@GetMapping("/persons/{id}")
	public ResponseEntity<Persons> get(@PathVariable Integer id) {
		try {
			Persons person = service.get(id);
			return new ResponseEntity<Persons>(person, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Persons>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/persons")
	public void add(@RequestBody Persons person) {
		service.save(person);
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<?> update(@RequestBody Persons person, @PathVariable Integer id) {
		try {
			Persons existProduct = service.get(id);
			service.save(person);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/persons/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}

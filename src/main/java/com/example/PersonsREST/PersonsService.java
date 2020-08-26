package com.example.PersonsREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonsService {

	@Autowired
	private PersonsRepository repo;

	public List<Persons> listAll() {
		return repo.findAll();
	}

	public void save(Persons person) {
		repo.save(person);
	}

	public Persons get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}

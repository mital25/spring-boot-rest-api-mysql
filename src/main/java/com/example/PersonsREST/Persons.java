package com.example.PersonsREST;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persons {

	@Id
	private int personid;
	private String lastname;
	private String firstname;
	private String address;
	private String city;

	public Persons() {
	}

	public Persons(int personid, String lastname, String firstname, String address, String city) {
		this.personid = personid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.city = city;
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

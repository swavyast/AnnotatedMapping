package com.ml.hibernate.entity;

import java.util.Set;

import com.ml.hibernate.enums.Gender;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;
	private String name;
	@ElementCollection
	@CollectionTable(name = "emails", joinColumns = @JoinColumn(name = "pId", referencedColumnName = "personId"))
	private Set<String> email;
	@ElementCollection
	@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "pId", referencedColumnName = "personId"))
	private Set<String> phone;
	private String fatherName;
	private String motherName;
	@OneToMany
	private Set<Address> address;
	@Enumerated
	private Gender gender;

	public Person() {
		// default constructor
	}

	public Person(Long personId, String name, Set<String> email, Set<String> phone, String fatherName,
			String motherName, Set<Address> address, Gender gender) {
		super();
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.gender = gender;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getEmail() {
		return email;
	}

	public void setEmail(Set<String> email) {
		this.email = email;
	}

	public Set<String> getPhone() {
		return phone;
	}

	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}

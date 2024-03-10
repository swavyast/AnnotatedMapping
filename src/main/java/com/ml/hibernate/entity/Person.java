package com.ml.hibernate.entity;

import com.ml.hibernate.enums.Gender;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String personId;
	private String name;
	private String email;
	private String phone;
	private String fatherName;
	private String motherName;
	@OneToMany
	private Address address;
	@Enumerated
	private Gender gender;

	public Person() {
		// default constructor
	}

	public Person(String name, String email, String phone, String fatherName, String motherName, Address address,
			Gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.gender = gender;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", address=" + address + ", gender="
				+ gender + "]";
	}

}

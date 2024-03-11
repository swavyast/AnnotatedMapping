package com.ml.hibernate.dao;

import com.ml.hibernate.entity.Person;

public interface PersonDao {

	public void savePerson(Person person);

	public Person getPersonById(String id);

}

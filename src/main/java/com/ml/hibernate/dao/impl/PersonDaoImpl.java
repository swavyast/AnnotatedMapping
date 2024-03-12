package com.ml.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ml.hibernate.configuration.DatabaseConfiguration;
import com.ml.hibernate.configuration.DatabaseUtil;
import com.ml.hibernate.dao.PersonDao;
import com.ml.hibernate.entity.Person;

public class PersonDaoImpl implements PersonDao {

	private static final Logger LOG = LoggerFactory.getLogger(PersonDaoImpl.class);
	private static final SessionFactory FACTORY = DatabaseConfiguration.getSessionFactory();
	private Session session;
	private Transaction tx;

	@Override
	public void savePerson(Person person) throws Exception {

		try {
			if (person != null) {
				session = FACTORY.getCurrentSession();
				if (tx == null || !tx.isActive()) {
					tx = session.beginTransaction();
				} else {
					tx = session.getTransaction();
				}
				LOG.info("saving person instance...");
				session.persist(person);
				tx.commit();
			}
		} catch (Exception e) {
			if (tx != null && !tx.isActive())
				tx.rollback();
			LOG.error("exception occurred while saving the student instance");
			DatabaseUtil.getDetailedStackTrace(e);
			throw new Exception("exception just for the purpose of providing a stack trace", e);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public Person getPersonById(String id) {

		return null;
	}

	private static <T extends Person> boolean isValidPerson(T t) {
		if (t != null)
			return t.getName() != null && t.getEmail() != null && t.getPhone() != null && t.getGender() != null
					&& t.getFatherName() != null && t.getMotherName() != null && t.getClass() != null;
		else
			return false;
	}

	public static <T extends Person> void savePersonalDetails(T t) throws Exception {
		if (PersonDaoImpl.isValidPerson(t)) {
			try {
				Person p = new Person(t.getName(), t.getEmail(), t.getEmail(), t.getFatherName(), t.getMotherName(),
						t.getAddress(), t.getGender());
				new PersonDaoImpl().savePerson(p);
			} catch (NullPointerException e) {
				LOG.error("some dependencies might be null. check the detailed stack trace for more information.");
				DatabaseUtil.getDetailedStackTrace(e);
			}
		}
	}
}

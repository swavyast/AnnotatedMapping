package com.ml.hibernate.configuration;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ml.hibernate.entity.Address;
import com.ml.hibernate.entity.Department;
import com.ml.hibernate.entity.Employee;
import com.ml.hibernate.entity.Person;
import com.ml.hibernate.entity.Student;
import com.ml.hibernate.entity.Teacher;

public class DatabaseConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);
	private static SessionFactory factory;

	private DatabaseConfiguration() {
		// private default constructor
	}

	static {
		Properties properties = new Properties();
		try (InputStream stream = DatabaseConfiguration.class.getClassLoader()
				.getResourceAsStream("application.properties")) {
			properties.load(stream);
			Configuration configuration = new Configuration().addPackage("com.ml.hibernate.entity")
					.addAnnotatedClass(Address.class).addAnnotatedClass(Department.class)
					.addAnnotatedClass(Employee.class).addAnnotatedClass(Person.class).addAnnotatedClass(Student.class)
					.addAnnotatedClass(Teacher.class).setProperties(properties);
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(ssr);
		} catch (FileNotFoundException e) {
			LOG.error("application.properties file was not found in resource directory.");
			e.printStackTrace();
		} catch (Exception e) {
			LOG.error("exception occured whlile configuring the database.");
			DatabaseUtil.getDetailedStackTrace(e);
		}

	}

	public static SessionFactory getSessionFactory() {

		LOG.info("session factory instance has been requested");

		return factory;
	}

}

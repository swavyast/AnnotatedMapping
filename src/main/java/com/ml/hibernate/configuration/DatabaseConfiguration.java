package com.ml.hibernate.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
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

	static {
		Properties properties = new Properties();
		try {
			InputStream stream = new FileInputStream("application.properties");
			properties.load(stream);
			Configuration configuration = new Configuration().addAnnotatedClass(Address.class)
					.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Person.class).addAnnotatedClass(Student.class).addAnnotatedClass(Teacher.class);
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(properties).build();
			factory = configuration.buildSessionFactory(ssr);
		} catch (FileNotFoundException e) {
			LOG.error("application.properties file was not found in resource directory.");
			e.printStackTrace();
		} catch (Exception e) {
			Throwable cause = e.getCause();
			String msg = e.getMessage();
			LOG.error("exception occured whlile configuring the database.");
			while (cause != null) {
				LOG.error(msg);
				msg = cause.getMessage();
				cause = cause.getCause();
			}
		}

	}

	public static SessionFactory getSessionFactory() {

		LOG.info("session factory instance has been requested");

		return factory;
	}

}

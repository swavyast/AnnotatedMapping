package com.ml.hibernate.dao.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ml.hibernate.configuration.DatabaseConfiguration;
import com.ml.hibernate.configuration.DatabaseUtil;
import com.ml.hibernate.dao.StudentDao;
import com.ml.hibernate.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private static final Logger LOG = LoggerFactory.getLogger(StudentDaoImpl.class);
	private static final SessionFactory FACTORY = DatabaseConfiguration.getSessionFactory();
	private Session session;
	private Transaction tx;

	@Override
	public void saveStudent(Student student) throws Exception {

		try {
			if (student != null) {
				PersonDaoImpl.savePersonalDetails(student);
				session = FACTORY.getCurrentSession();
				if (tx == null || !tx.isActive()) {
					tx = session.beginTransaction();
				} else {
					tx = session.getTransaction();
				}
				session.persist(student);
				tx.commit();
			}

		} catch (Exception e) {
			if (tx != null && !tx.isActive())
				tx.rollback();
			LOG.error("exception occurred while saving student instance.");
			DatabaseUtil.getDetailedStackTrace(e);
			throw new Exception("exception just for the purpose of providing a stack trace", e);
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public Student getStudentById(String sid) {

		return null;
	}

	public static String findReportCard(String string) {
		Path path = Paths.get("./reportCards", "rc_", string.replace(" ", ""));
		File file = new File(path.toUri());
		return file.toString();
	}

	public static File generateReportCard(String string) throws InstantiationException, IllegalAccessException {

		try {
			return File.createTempFile(string, ".docx");
		} catch (IOException e) {
			LOG.error(String.format("exception occurred while generating report card for %s", string));
			DatabaseUtil.getDetailedStackTrace(e);
			return File.class.newInstance();
		}
	}

}

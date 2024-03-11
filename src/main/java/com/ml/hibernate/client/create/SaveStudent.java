package com.ml.hibernate.client.create;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ml.hibernate.configuration.DatabaseUtil;
import com.ml.hibernate.dao.impl.StudentDaoImpl;
import com.ml.hibernate.entity.Address;
import com.ml.hibernate.entity.Student;
import com.ml.hibernate.entity.Teacher;
import com.ml.hibernate.enums.Batch;
import com.ml.hibernate.enums.Gender;
import com.ml.hibernate.enums.Mode;
import com.ml.hibernate.enums.Subject;

public class SaveStudent {

	private static final Logger LOG = LoggerFactory.getLogger(SaveStudent.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Student student0 = new Student();
		// personal details
		student0.setName("Abhinav Rai");
		student0.setEmail("abhinav@email.com");
		student0.setPhone("+91-7576777899");
		student0.setFatherName("Santosh Rai");
		student0.setMotherName("Pushpa Rai");
		student0.setGender(Gender.MALE);
		Address address = new Address("Balua", "Taraw", "Bhawarkol", "Ghazipur", "Uttar Pradesh", "India", 233002);
		student0.setAddress(address);
		// educational details
		student0.setBalance(-25.00);
		student0.setFeePaid(22567.36);
		student0.setFeeSubmitted(true);
		student0.setHasLibraryCard(true);
		student0.setLibraryCard(String.valueOf(student0.hashCode()));
		Map<Mode, Batch> mode = new EnumMap<>(Mode.class);
		mode.put(Mode.OFFLINE, Batch.REGULAR);
		student0.setMode(mode);
		student0.setRembursement(00.00);
		student0.setReportCard(StudentDaoImpl.findReportCard("Abhinav Rai"));
		try {
			StudentDaoImpl.generateReportCard("Abhinav Rai");
		} catch (InstantiationException | IllegalAccessException e) {

			DatabaseUtil.getDetailedStackTrace(e);
		}
		student0.setScholarshipAmount(00.00);
		student0.setScholarshipEligible(false);
		Set<Subject> subjects = new HashSet<>();
		subjects.add(Subject.GEOGRAPHY);
		subjects.add(Subject.HISTORY);
		subjects.add(Subject.ENGLISH);
		student0.setSubjects(subjects);
		Map<Teacher, Subject> tutors = new HashMap<>(10);
		tutors.put(new Teacher(), Subject.GEOGRAPHY);
		tutors.put(new Teacher(), Subject.HISTORY);
		tutors.put(new Teacher(), Subject.ENGLISH);
		student0.setTutors(tutors);
		new StudentDaoImpl().saveStudent(student0);
	}

}

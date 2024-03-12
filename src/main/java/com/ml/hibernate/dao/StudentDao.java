package com.ml.hibernate.dao;

import com.ml.hibernate.entity.Student;

public interface StudentDao {

	public void saveStudent(Student student) throws Exception;

	public Student getStudentById(String sid);
}
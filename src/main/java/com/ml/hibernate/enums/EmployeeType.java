package com.ml.hibernate.enums;

public enum EmployeeType {

	TEACHER("Teacher"), MANAGER("Manager"), ADMINISTRATOR("Administrator"), CLERK("Clerk"), TYPIST("Typist"),
	PROGRAMMER("Programmer"), JAVADEVELOPER("Java Developer"), FULLSTACKDEVELOPER("Full Stack Developer"),
	MEANSTACKDEVELOPER("MEAN Stack Developer"), MERNSTACKDEVELOPER("MERN Stack Developer"),
	NODEJSDEVELOPER("Node.JS Developer");

	String name;

	EmployeeType(String name) {
		this.name = name;
	}
}

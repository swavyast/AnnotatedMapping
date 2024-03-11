package com.ml.hibernate.entity;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.ml.hibernate.enums.Classroom;
import com.ml.hibernate.enums.Subject;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
public class Teacher extends Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String tid;
	@OneToOne
	private Department dept;
	@OneToOne
	private Employee manager;
	@OneToMany
	private Set<Teacher> colleagues;
	@ManyToAny
	private Map<Subject, Map<Classroom, LocalTime>> schedule;

	public Teacher() {
		// default constructor
	}

	public Teacher(String tid, Department dept, Employee manager, Set<Teacher> colleagues,
			Map<Subject, Map<Classroom, LocalTime>> schedule) {
		super();
		this.tid = tid;
		this.dept = dept;
		this.manager = manager;
		this.colleagues = colleagues;
		this.schedule = schedule;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Teacher> getColleagues() {
		return colleagues;
	}

	public void setColleagues(Set<Teacher> colleagues) {
		this.colleagues = colleagues;
	}

	public Map<Subject, Map<Classroom, LocalTime>> getSchedule() {
		return schedule;
	}

	public void setSchedule(Map<Subject, Map<Classroom, LocalTime>> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", dept=" + dept + ", manager=" + manager + ", colleagues=" + colleagues
				+ ", schedule=" + schedule + "]";
	}

}

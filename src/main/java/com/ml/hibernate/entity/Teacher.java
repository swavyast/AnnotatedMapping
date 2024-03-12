package com.ml.hibernate.entity;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

import com.ml.hibernate.enums.Classroom;
import com.ml.hibernate.enums.Subject;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Teacher extends Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	@OneToOne
	private Department dept;
	@ManyToOne
	private Employee manager;
	@OneToMany
	@CollectionTable
	private Set<Teacher> colleagues;
	@CollectionTable
	@MapKeyEnumerated
	private Map<Subject, Map<Classroom, LocalTime>> schedule;

	public Teacher() {
		// default constructor
	}

	public Teacher(Department dept, Employee manager, Set<Teacher> colleagues,
			Map<Subject, Map<Classroom, LocalTime>> schedule) {
		super();
		this.dept = dept;
		this.manager = manager;
		this.colleagues = colleagues;
		this.schedule = schedule;
	}

	public Long getteacherId() {
		return teacherId;
	}

	public void setteacherId(Long teacherId) {
		this.teacherId = teacherId;
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
		return "Teacher [teacherId=" + teacherId + ", dept=" + dept + ", manager=" + manager + ", colleagues="
				+ colleagues + ", schedule=" + schedule + "]";
	}

}

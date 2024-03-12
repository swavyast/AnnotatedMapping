package com.ml.hibernate.entity;

import org.hibernate.annotations.Formula;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Employee extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String eType;
	private Double basic;
	private Double bonus;
	private Double ta;
	private Double da;
	private Double hra;
	@Formula(value = "basic+ta+da+hra+bonus")
	private Double gross;
	@OneToOne
	private Department dept;

	public Employee() {
		// default constructor.
	}

	public Employee(String eType, Double basic, Double bonus, Double ta, Double da, Double hra, Double gross,
			Department dept) {
		super();
		this.eType = eType;
		this.basic = basic;
		this.bonus = bonus;
		this.ta = ta;
		this.da = da;
		this.hra = hra;
		this.gross = gross;
		this.dept = dept;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String geteType() {
		return eType;
	}

	public void seteType(String eType) {
		this.eType = eType;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getTa() {
		return ta;
	}

	public void setTa(Double ta) {
		this.ta = ta;
	}

	public Double getDa() {
		return da;
	}

	public void setDa(Double da) {
		this.da = da;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getGross() {
		return gross;
	}

	public void setGross(Double gross) {
		this.gross = gross;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", eType=" + eType + ", basic=" + basic + ", bonus=" + bonus + ", ta=" + ta
				+ ", da=" + da + ", hra=" + hra + ", gross=" + gross + ", dept=" + dept + "]";
	}

}

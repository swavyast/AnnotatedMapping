package com.ml.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Department {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	private String name;
	private Employee head;
	private Double budget;
	@Column(name = "expense")
	private Double expenditure;
	private Double balance;
	@Column(name = "costS")
	private Double stationaryCost;
	@Column(name = "costA")
	private Double aminitiesCost;

	public Department() {
		// default constructor.
	}

	public Department(String name, Employee head, Double budget, Double expenditure, Double balance,
			Double stationaryCost, Double aminitiesCost) {
		super();
		this.name = name;
		this.head = head;
		this.budget = budget;
		this.expenditure = expenditure;
		this.balance = balance;
		this.stationaryCost = stationaryCost;
		this.aminitiesCost = aminitiesCost;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getHead() {
		return head;
	}

	public void setHead(Employee head) {
		this.head = head;
	}

	public Double getbudget() {
		return budget;
	}

	public void setbudget(Double budget) {
		this.budget = budget;
	}

	public Double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(Double expenditure) {
		this.expenditure = expenditure;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getStationaryCost() {
		return stationaryCost;
	}

	public void setStationaryCost(Double stationaryCost) {
		this.stationaryCost = stationaryCost;
	}

	public Double getAminitiesCost() {
		return aminitiesCost;
	}

	public void setAminitiesCost(Double aminitiesCost) {
		this.aminitiesCost = aminitiesCost;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + ", head=" + head + ", budget=" + budget
				+ ", expenditure=" + expenditure + ", balance=" + balance + ", stationaryCost=" + stationaryCost
				+ ", aminitiesCost=" + aminitiesCost + "]";
	}

}

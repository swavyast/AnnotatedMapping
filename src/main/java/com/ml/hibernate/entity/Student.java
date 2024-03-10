package com.ml.hibernate.entity;

import java.util.Map;
import java.util.Set;

import com.ml.hibernate.enums.Batch;
import com.ml.hibernate.enums.Mode;
import com.ml.hibernate.enums.Subject;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "stud")
public class Student extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String studentId;
	@OneToMany
	@MapKeyEnumerated
	private Set<Subject> subjects;
	@OneToMany
	@MapKeyEnumerated
	private Map<Teacher, Subject> tutors;
	@Column(name = "rCard")
	private String reportCard;
	@Column(name = "lCard")
	private String libraryCard;
	@Column(name = "paid")
	private Double feePaid;
	private Double balance;
	@Column(name = "remAmt")
	private Double rembursement;
	@Column(name = "ssAmt")
	private Double scholarshipAmount;
	private Boolean feeCheck;
	private Boolean scholarshipEligible;
	private Boolean hasLibraryCard;
	@OneToMany
	@MapKeyEnumerated
	private Map<Mode, Batch> mode;

	public Student() {
		// default constructor
	}

	public Student(String studentId, Set<Subject> subjects, Map<Teacher, Subject> tutors, String reportCard,
			String libraryCard, Double feePaid, Double balance, Double rembursement, Double scholarshipAmount,
			Boolean feeCheck, Boolean scholarshipEligible, Boolean hasLibraryCard, Map<Mode, Batch> mode) {
		super();
		this.studentId = studentId;
		this.subjects = subjects;
		this.tutors = tutors;
		this.reportCard = reportCard;
		this.libraryCard = libraryCard;
		this.feePaid = feePaid;
		this.balance = balance;
		this.rembursement = rembursement;
		this.scholarshipAmount = scholarshipAmount;
		this.feeCheck = feeCheck;
		this.scholarshipEligible = scholarshipEligible;
		this.hasLibraryCard = hasLibraryCard;
		this.mode = mode;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Map<Teacher, Subject> getTutors() {
		return tutors;
	}

	public void setTutors(Map<Teacher, Subject> tutors) {
		this.tutors = tutors;
	}

	public String getReportCard() {
		return reportCard;
	}

	public void setReportCard(String reportCard) {
		this.reportCard = reportCard;
	}

	public String getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(String libraryCard) {
		this.libraryCard = libraryCard;
	}

	public Double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(Double feePaid) {
		this.feePaid = feePaid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getRembursement() {
		return rembursement;
	}

	public void setRembursement(Double rembursement) {
		this.rembursement = rembursement;
	}

	public Double getScholarshipAmount() {
		return scholarshipAmount;
	}

	public void setScholarshipAmount(Double scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
	}

	public Boolean getFeeSubmitted() {
		return feeCheck;
	}

	public void setFeeSubmitted(Boolean feeCheck) {
		this.feeCheck = feeCheck;
	}

	public Boolean getScholarshipEligible() {
		return scholarshipEligible;
	}

	public void setScholarshipEligible(Boolean scholarshipEligible) {
		this.scholarshipEligible = scholarshipEligible;
	}

	public Boolean getHasLibraryCard() {
		return hasLibraryCard;
	}

	public void setHasLibraryCard(Boolean hasLibraryCard) {
		this.hasLibraryCard = hasLibraryCard;
	}

	public Map<Mode, Batch> getMode() {
		return mode;
	}

	public void setMode(Map<Mode, Batch> mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", subjects=" + subjects + ", tutors=" + tutors + ", reportCard="
				+ reportCard + ", libraryCard=" + libraryCard + ", feePaid=" + feePaid + ", balance=" + balance
				+ ", rembursement=" + rembursement + ", scholarshipAmount=" + scholarshipAmount + ", feeCheck="
				+ feeCheck + ", scholarshipEligible=" + scholarshipEligible + ", hasLibraryCard=" + hasLibraryCard
				+ ", mode=" + mode + "]";
	}

}

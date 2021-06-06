package com.codes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainee_details")
public class Trainee {
	
	@Id
	@Column(name="trainee_id",length=4)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int traineeId;
	@Column(name="trainee_name",length=15)
	private String name;
	@Column(name="course",length=15)
	private String course;
	@Column(name="mobile_number",length=10)
	private String mobileNumber;
	
	@OneToOne(cascade= {CascadeType.ALL}) //From Cascade any change in Trainee table will be reflected in to University table
	@JoinColumn
	private University university;
	
	public Trainee() {}

	public Trainee(String name, String course, String mobileNumber) {
		super();
		this.name = name;
		this.course = course;
		this.mobileNumber = mobileNumber;
	}
	
	

	public Trainee(String name, String course, String mobileNumber, University university) {
		super();
		this.name = name;
		this.course = course;
		this.mobileNumber = mobileNumber;
		this.university = university;
	}

	
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public int getTraineeId() {
		return traineeId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return name+"\t"+course+"\t"+mobileNumber+"\t"+university;
	}
	

}

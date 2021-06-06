package com.codes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
@Table
public class University {

	@Id
	@GeneratedValue
	@Column(name="add_id")
	int UniId;
	@Column(length=20)
	String uniName;
	@Column(length=20)
	String uniCity;
	
	public University() {}
	
	public University(int uniId, String uniName, String uniCity) {
		super();
		UniId = uniId;
		this.uniName = uniName;
		this.uniCity = uniCity;
	}
	
	public University(String uniName, String uniCity) {
		super();
		this.uniName = uniName;
		this.uniCity = uniCity;
	}
	
	public int getUniId() {
		return UniId;
	}
	public void setUniId(int uniId) {
		UniId = uniId;
	}
	public String getUniName() {
		return uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	public String getUniCity() {
		return uniCity;
	}
	public void setUniCity(String uniCity) {
		this.uniCity = uniCity;
	}

	
	@Override
	public String toString() {
		return uniName+"\t"+uniCity;
	}
	
}

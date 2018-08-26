package org.liferayasif.front.controller;

public class SchoolDto {
	
	private Integer id;
	private String schoolName;
	private int noStudent;
	private String location;
	private int fees;
	
	public SchoolDto (){};
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getNoStudent() {
		return noStudent;
	}
	public void setNoStudent(int noStudent) {
		this.noStudent = noStudent;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}

}
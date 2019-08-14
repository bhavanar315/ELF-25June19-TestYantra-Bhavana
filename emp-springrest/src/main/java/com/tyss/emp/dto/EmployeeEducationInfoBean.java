package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
//@Data
//@XmlAccessorType(XmlAccessType.FIELD)
@Table(name="employee_education_info")
public class EmployeeEducationInfoBean implements Serializable{
	
	@EmbeddedId
	private EducationPKBean educationbean;
	@Column(name="COLLEGE_NM")
	private String collegeName;
	@Column(name="UNIVERSITY")
	private String university;
	@Column(name="LOCATION")
	private String location;
	@Column(name="BRANCH")
	private String branch;
	@Column(name="DEGREE_TYPE")
	private String degreeType;
	@Column(name="PERCENTAGE")
	private String percentage;
	@Column(name="YOP")
	private int yop;
	public EducationPKBean getEducationbean() {
		return educationbean;
	}
	public void setEducationbean(EducationPKBean educationbean) {
		this.educationbean = educationbean;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDegreeType() {
		return degreeType;
	}
	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
	
	
	
}

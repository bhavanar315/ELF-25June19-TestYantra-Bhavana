package com.tyss.springbootExample.dta;

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
import lombok.ToString.Exclude;


@Entity
@Data
@Table(name="employee_education_info")
public class EmployeeEducationInfoBean implements Serializable{
	
	@Exclude
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
	
	
	
	
}

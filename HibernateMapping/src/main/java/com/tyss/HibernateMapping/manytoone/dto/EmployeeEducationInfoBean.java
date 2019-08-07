package com.tyss.HibernateMapping.manytoone.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_educationinfo")
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
	
}

package com.tyss.emp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_experienceinfo")
public class EmployeeExperienceInfoBean implements Serializable{
	
	@EmbeddedId
    private ExperiencePKBean expbean;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="JOINING_DATE")
	private Date joiningDate;
	@Column(name="LEAVING_DATE")
	private Date leavingDate;
	
}

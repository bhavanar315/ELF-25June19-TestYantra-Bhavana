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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//@Data
//@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="employee_experience_info")
public class EmployeeExperienceInfoBean implements Serializable{
	
	@EmbeddedId
    private ExperiencePKBean expbean;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="JOINING_DATE")
	private Date joiningDate;
	@Column(name="LEAVING_DATE")
	private Date leavingDate;
	public ExperiencePKBean getExpbean() {
		return expbean;
	}
	public void setExpbean(ExperiencePKBean expbean) {
		this.expbean = expbean;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
	
	
}

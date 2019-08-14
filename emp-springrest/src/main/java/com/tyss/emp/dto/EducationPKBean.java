package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.Data;
import lombok.ToString;

//@Data
//@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class EducationPKBean implements Serializable{
	
	//@XmlTransient
	@JsonIgnore
	@JoinColumn(name="id")
    @ManyToOne
	private EmployeeInfoBean bean;
	@JsonProperty(value="EDUCATION_TYPE")
	@Column(name="EDUCATION_TYPE")
	private String educationType;
	public EmployeeInfoBean getBean() {
		return bean;
	}
	public void setBean(EmployeeInfoBean bean) {
		this.bean = bean;
	}
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	
	
}

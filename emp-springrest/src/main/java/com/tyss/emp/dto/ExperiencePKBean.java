package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.Data;



//@Data

@Embeddable
//@XmlAccessorType(XmlAccessType.FIELD)
public class ExperiencePKBean implements Serializable {
	//@XmlTransient
	@JsonIgnore
	@JoinColumn(name="id")
    @ManyToOne
	private EmployeeInfoBean bean;
	@JsonProperty(value="company_name")
	@Column(name="company_name")
	private String company;
	public EmployeeInfoBean getBean() {
		return bean;
	}
	public void setBean(EmployeeInfoBean bean) {
		this.bean = bean;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}

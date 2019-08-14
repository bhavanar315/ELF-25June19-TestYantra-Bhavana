package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.Data;
import lombok.ToString;

//@Data
@Embeddable
//@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeAddressPkbean implements Serializable{
	
	//@XmlTransient
	@JsonIgnore
	@JoinColumn(name="id")
    @ManyToOne
	private EmployeeInfoBean bean;
	@JsonProperty(value="ADDRESS_TYPE")
	@Column(name="ADDRESS_TYPE")
	private String addressType;
	public EmployeeInfoBean getBean() {
		return bean;
	}
	public void setBean(EmployeeInfoBean bean) {
		this.bean = bean;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
    
    
}

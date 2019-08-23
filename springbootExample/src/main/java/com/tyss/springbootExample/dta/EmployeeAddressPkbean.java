package com.tyss.springbootExample.dta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;


@Data
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
	
	
    
    
}

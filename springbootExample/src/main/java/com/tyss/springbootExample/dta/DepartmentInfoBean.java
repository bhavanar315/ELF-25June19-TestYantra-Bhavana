package com.tyss.springbootExample.dta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="department_info")
//@Data
//@XmlAccessorType(XmlAccessType.FIELD)
 public class DepartmentInfoBean implements Serializable{
	
	@JsonIgnore
	@Id
	@Column(name="dept_id")
	private int deptid; 
	@Column(name="dept_name")
	private String deptName;
	
	

}

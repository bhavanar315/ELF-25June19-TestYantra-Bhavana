package com.tyss.HibernateMapping.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tyss.HibernateMapping.onetoone.dto.EmployeeOtherInfoBean;
import com.tyss.HibernateMapping.onetoone.dto.EmpolyeeInfoBean;

import lombok.Data;
@Entity
@Table(name="BidirectionalMapping")
@Data
public class BidirectionalMappingBean implements Serializable{

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "empbean")
	private EmployeeOtherInfoBean otherbean;
	
	
	@Id
	@Column(name="id")
	private int id ;	
	@Column(name="name")
	private  String name; 	
	@Column(name="age")
	private int age	; 
	@Column(name="gender")
	private String gender 	;		
	@Column(name="salary")
	private double  salary ;	
	@Column(name="phone")
	private long phone 	;
	@Column(name="joiningDate")
	private Date joiningDate; 
	@Column(name="acno")
	private	long acno;  
	@Column(name="email")
	private String email 	;
	@Column(name="designation")
	private String designation		; 
	@Column(name="dob")
	private Date dob;	
	
	@JoinColumn(name="deptid")
	@ManyToOne
	private DepartmentInfoBean deptid;
	
	@ManyToOne
	@JoinColumn(name="managerid", referencedColumnName = "ID")
	private EmpolyeeInfoBean managerid;
	
	
}

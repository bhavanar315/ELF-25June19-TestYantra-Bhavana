package com.tyss.HibernateMapping.onetoone.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tyss.HibernateMapping.dto.DepartmentInfoBean;
import com.tyss.HibernateMapping.manytomany.dto.TrainingInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeAddressInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeEducationInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeExperienceInfoBean;

import lombok.Data;

@Entity
@Table(name="EmpolyeeInfoBean")
@Data
public class EmpolyeeInfoBean implements Serializable{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPkBean.bean")
	private List<EmployeeAddressInfoBean> addressbean;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationbean.bean")
	private List<EmployeeEducationInfoBean> educationbean;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "expbean.bean")
	private List<EmployeeExperienceInfoBean> experiencebean;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infobean")
	private List<TrainingInfoBean> trainingbean;
	
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

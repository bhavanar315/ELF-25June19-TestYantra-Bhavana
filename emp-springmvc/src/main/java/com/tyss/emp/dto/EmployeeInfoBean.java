package com.tyss.emp.dto;

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

import org.springframework.format.annotation.DateTimeFormat;


import com.tyss.emp.dto.EmployeeOtherInfoBean;

import lombok.Data;
@Data
@Entity
@Table(name="employee_info")
public class EmployeeInfoBean implements Serializable{
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "bean")
	private EmployeeOtherInfoBean otherbean;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPkBean.bean")
	private List<EmployeeAddressInfoBean> addressbean;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationbean.bean")
	private List<EmployeeEducationInfoBean> educationbean;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "expbean.bean")
	private List<EmployeeExperienceInfoBean> experiencebean;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infobean")
	private List<TrainingInfoBean> trainingbean;
	
	@Id
	private int id;
	@Column(name="name")
	private String empName;
	private String password;
	private int age;
	private String gender;
	private double salary;
	private long phone;
	@Column(name="joining_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date joiningDate;
	@Column(name="account_number")
	private long accountNumber;
	private String email;
	private String designation;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dob;
	
	@JoinColumn(name="deptid")
	@ManyToOne
	private DepartmentInfoBean deptid;
	
	@ManyToOne
	@JoinColumn(name="managerid", referencedColumnName = "ID")
	private EmployeeInfoBean managerid;
	
}

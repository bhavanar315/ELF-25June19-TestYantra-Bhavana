package com.tyss.emp.dto;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="emp_info")
@Data
public class EmpInfoBean implements Serializable{
	
	
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
		@Column(name="deptid")
	private int deptid;
		@Column(name="managerid")
	private int managerid;

}

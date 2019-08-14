package com.tyss.emp.model;

import java.util.Date;

import lombok.Data;
@Data
public class EmployeeInfoModel {
	
	private int id;
	private String empName;
	private String password;
	private int age;
	private String gender;
	private double salary;
	private long phone;
	private Date joiningDate;
	private long accountNumber;
	private String email;
	private String designation;
	private Date dob;
	private int departmentId;
	private int managerId;
	
	
}
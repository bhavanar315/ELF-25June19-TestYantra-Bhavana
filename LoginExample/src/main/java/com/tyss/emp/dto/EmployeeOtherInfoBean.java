package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Employee_OtherInfo")
@Data
public class EmployeeOtherInfoBean implements Serializable{
		
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="PAN")
	private String panNum;
	
	@Column(name="AADHAR_NUMBER")
	private long aadharNm;
	
	@Column(name="PASSPORT_NUMBER")
	private String passportNm;
	
	@Column(name="ISMARRIED")
	private boolean ismarried;
	
	@Column(name="BLOOD_GRP")
	private String bloodGroup;
	
	@Column(name="NATINALITY")
	private String nationality;
	
	@Column(name="EMERGENCY_CONTACT_NUMBER")
	private long emergencyContactNm;
	
	@Column(name="EMERGENCY_CONTACT_NAME")
	private String emergencyContactName;
	
	@Column(name="RELIGION")
    private String religion;
	
	@Column(name="MOTHER_NM")
    private String motherName;
	
	@Column(name="FATHER_NM")
    private String fatherName;
	
	@Column(name="SPOUSE_NM")
    private String spouseName;
	
	@Column(name="ISCHALLANGED")
    private boolean isChallanged;

}

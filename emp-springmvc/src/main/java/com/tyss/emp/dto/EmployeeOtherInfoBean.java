package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee_other_info")
public class EmployeeOtherInfoBean implements Serializable{
	
	@Id
	@OneToOne
	@JoinColumn(name="ID")
	private EmployeeInfoBean bean;
	
	@Column(name="pan")
	private String pan;
	@Column(name="is_married")
	private boolean isMarried;
	@Column(name="blood_grp")
	private String bloodGrp;
	@Column(name="is_challenged")
	private boolean isChallenged;
	@Column(name="emergency_contact_number")
	private long emergencyContactNumber;
	@Column(name="emergency_contact_name")
	private String emergencyContactName;
	@Column(name="nationality")
	private String nationality;
	@Column(name="religion")
	private String religion;
	@Column(name="father_nm")
	private String fatherName;
	@Column(name="mother_nm")
	private String motherName;
	@Column(name="spouse_nm")
	private String spouseName;
	@Column(name="passport")
	private String	passport;
	@Column(name="aadhaar")
	private long adhaar;
}

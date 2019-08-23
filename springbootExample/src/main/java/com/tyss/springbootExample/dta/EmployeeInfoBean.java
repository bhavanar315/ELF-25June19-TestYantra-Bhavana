package com.tyss.springbootExample.dta;

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


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import lombok.Data;




@Data
@JsonRootName(value="employee-info")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
@Entity
@Table(name="employee_info")
public class EmployeeInfoBean implements Serializable{
	
	
	@JsonProperty(value="otherinfo")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "bean")
	private EmployeeOtherInfoBean otherbean;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPkBean.bean")
	private List<EmployeeAddressInfoBean> addressbean;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationbean.bean")
	private List<EmployeeEducationInfoBean> educationbean;
	
	
	@JsonProperty(value="experienceinfo")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "expbean.bean")
	private List<EmployeeExperienceInfoBean> experiencebean;
	
	
	@JsonProperty(value="traininginfo")
	  @LazyCollection(LazyCollectionOption.FALSE)
	  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "infobean") private
	  List<TrainingInfoBean> trainingbean;
	  
	/*
	 * @JsonProperty(value="departmentinfo")
	 * 
	 * @JoinColumn(name="dept_id")
	 * 
	 * @ManyToOne private DepartmentInfoBean dept_id;
	 */
	private Integer dept_id;
	@JsonProperty(value="mangerinfo")
	@ManyToOne
	@JoinColumn(name="managerid", referencedColumnName = "id")
	private EmployeeInfoBean managerid;
	
	//@JsonProperty("id")
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String empName;
	private String password;
	private Integer age;
	@JsonProperty(value="Gender")
	private String gender;
	private Double salary;
	private Long phone;
	@Column(name="joining_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date joiningDate;
	@Column(name="account_number")
	private Long accountNumber;
	private String email;
	private String designation;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dob;

	
	
		
}

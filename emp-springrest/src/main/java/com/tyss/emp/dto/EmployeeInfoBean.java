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


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tyss.emp.dto.EmployeeOtherInfoBean;

import lombok.Data;
import lombok.ToString;



//@XmlRootElement(name="employee-info-bean")
//@XmlAccessorType(XmlAccessType.FIELD)
//@Data
@JsonRootName(value="employee-info")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
@Entity
@Table(name="employee_info")
public class EmployeeInfoBean implements Serializable{
	
	//@XmlElement(name="other-bean")
	@JsonProperty(value="otherinfo")
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "bean" )
	private EmployeeOtherInfoBean otherbean;
	
	//@XmlElement(name="address-bean")
	//@JsonProperty(value="Addressinfo")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPkBean.bean")
	private List<EmployeeAddressInfoBean> addressbean;
	
	//@XmlElement(name="education-bean")
	//@JsonProperty(value="education info")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationbean.bean")
	private List<EmployeeEducationInfoBean> educationbean;
	
	//@XmlElement(name="experience-bean")
	@JsonProperty(value="experienceinfo")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "expbean.bean")
	private List<EmployeeExperienceInfoBean> experiencebean;
	
	//@XmlElement(name="training-bean")
	//@JsonProperty(value="traininginfo")
	/*
	 * @LazyCollection(LazyCollectionOption.FALSE)
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL, mappedBy = "infobean") private
	 * List<TrainingInfoBean> trainingbean;
	 * 
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
	
	@JsonProperty("id")
	@Id
	private int id;
	@Column(name="name")
	private String empName;
	private String password;
	
	//@XmlElement(name="Age")
	//@JsonProperty(value="Age")
	private Integer age;
	
	@JsonProperty(value="Gender")
	private String gender;
	private Double salary;
	private Long phone;
	
	//@JsonProperty(value="JoiningDate")
	@Column(name="joining_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date joiningDate;
	
	@Column(name="account_number")
	private Long accountNumber;
	private String email;
	private String designation;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dob;
	public EmployeeOtherInfoBean getOtherbean() {
		return otherbean;
	}
	public void setOtherbean(EmployeeOtherInfoBean otherbean) {
		this.otherbean = otherbean;
	}
	public List<EmployeeAddressInfoBean> getAddressbean() {
		return addressbean;
	}
	public void setAddressbean(List<EmployeeAddressInfoBean> addressbean) {
		this.addressbean = addressbean;
	}
	public List<EmployeeEducationInfoBean> getEducationbean() {
		return educationbean;
	}
	public void setEducationbean(List<EmployeeEducationInfoBean> educationbean) {
		this.educationbean = educationbean;
	}
	public List<EmployeeExperienceInfoBean> getExperiencebean() {
		return experiencebean;
	}
	public void setExperiencebean(List<EmployeeExperienceInfoBean> experiencebean) {
		this.experiencebean = experiencebean;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public EmployeeInfoBean getManagerid() {
		return managerid;
	}
	public void setManagerid(EmployeeInfoBean managerid) {
		this.managerid = managerid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	

	
		
}

package com.tyss.emp.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.Data;

@Entity
//@Data
//@XmlAccessorType(XmlAccessType.FIELD)
@Table(name="TrainingInfo")
public class TrainingInfoBean implements Serializable {
	
	@JsonIgnore
	@Id
	@Column(name="COURSE_ID")
	private int courseId;
	@Column(name="COURSE_NM")
	private String courseName;
	@Column(name="DURATION")
	private String duration;
	@Column(name="COURSE_TYPE")
	private String courseType;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="EmployeeTraningInfoBean", joinColumns = 
			{@JoinColumn(name="COURSE_ID")},
			inverseJoinColumns = @JoinColumn(name="id"))
	List<EmployeeInfoBean> infobean;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<EmployeeInfoBean> getInfobean() {
		return infobean;
	}

	public void setInfobean(List<EmployeeInfoBean> infobean) {
		this.infobean = infobean;
	}

	
	
}

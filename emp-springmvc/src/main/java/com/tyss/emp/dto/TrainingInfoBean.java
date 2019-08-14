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

import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.Data;

@Data
@Entity
@Table(name="TrainingInfo")
public class TrainingInfoBean implements Serializable {
	
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
	

}

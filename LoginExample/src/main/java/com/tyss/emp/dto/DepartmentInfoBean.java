package com.tyss.emp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="dept_info")
@Data
 public class DepartmentInfoBean implements Serializable{
	@Id
	@Column(name="deptid")
	private int deptid;
	@Column(name="deptname")
	private String deptName;	

}

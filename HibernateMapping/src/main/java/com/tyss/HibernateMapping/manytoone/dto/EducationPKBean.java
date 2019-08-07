package com.tyss.HibernateMapping.manytoone.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tyss.HibernateMapping.onetoone.dto.EmpolyeeInfoBean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Embeddable
public class EducationPKBean implements Serializable{
	
	@JoinColumn(name="id")
    @ManyToOne
	private EmpolyeeInfoBean bean;
	@Column(name="EDUCATION_TYPE")
	private String educationType;

}

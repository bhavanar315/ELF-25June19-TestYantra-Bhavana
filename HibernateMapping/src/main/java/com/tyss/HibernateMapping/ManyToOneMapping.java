package com.tyss.HibernateMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import com.tyss.HibernateMapping.hibernateimpl.HibernateImpl;
import com.tyss.HibernateMapping.manytomany.dto.TrainingInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EducationPKBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeAddressInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeAddressPkbean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeEducationInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeExperienceInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.ExperiencePKBean;
import com.tyss.HibernateMapping.onetoone.dto.EmployeeOtherInfoBean;
import com.tyss.HibernateMapping.onetoone.dto.EmpolyeeInfoBean;

public class ManyToOneMapping{
	public static void main(String[] args) throws ParseException {
		HibernateImpl impl = new HibernateImpl();
		
		EmpolyeeInfoBean bean = impl.getEmpolyeeInfoBeanById(1);
		
		//OneToOne Mapping
       EmployeeOtherInfoBean otherbean = new EmployeeOtherInfoBean();
		otherbean.setAadharNm(12345);
		otherbean.setPanNum("bnsd1234k");
		otherbean.setBloodGroup("b+ve");
		otherbean.setChallanged(false);
		otherbean.setFatherName("Pavan");
		otherbean.setMotherName("Renuka");
		otherbean.setIsmarried(false);
		//otherbean.setEmpbean(bean);
		
		//ManyToOne Mapping
		EmployeeAddressPkbean addressPkBean=new EmployeeAddressPkbean();
		addressPkBean.setAddressType("Temp");
		addressPkBean.setBean(bean);
		EmployeeAddressPkbean addressPkBean1=new EmployeeAddressPkbean();
		addressPkBean1.setAddressType("perm");
		addressPkBean1.setBean(bean);
		
		EmployeeAddressInfoBean addressbean = new EmployeeAddressInfoBean();
		addressbean.setAddress1("bbvbvcb");
		addressbean.setAddress2("Jayanagr");
		addressbean.setCity("Bangalore");
		addressbean.setCountry("India");
		addressbean.setDistrict("South");
		addressbean.setLandmark("Central mall");
		addressbean.setPincode(560069);
		addressbean.setState("KA");
		addressbean.setAddressPkBean(addressPkBean);
		
		EmployeeAddressInfoBean addressbean1 = new EmployeeAddressInfoBean();
		addressbean1.setAddressPkBean(addressPkBean1);
		addressbean1.setAddress1("bbvbvcb");
		addressbean1.setAddress2("Jayanagr");
		addressbean1.setCity("Bangalore");
		addressbean1.setCountry("India");
		addressbean1.setDistrict("South");
		addressbean1.setLandmark("Central mall");
		addressbean1.setPincode(560069);
		addressbean1.setState("KA");
		
//		List<EmployeeAddressInfoBean> addressbeanlist = new ArrayList<EmployeeAddressInfoBean>();
//		addressbeanlist.add(addressbean);
//		addressbeanlist.add(addressbean1);
		
		EducationPKBean edubean = new EducationPKBean();
		edubean.setEducationType("Degree");
		edubean.setBean(bean);
		
		EducationPKBean edubean1 = new EducationPKBean();
		edubean1.setEducationType("Phd");
		edubean1.setBean(bean);
		
		
		EmployeeEducationInfoBean educationinfo = new EmployeeEducationInfoBean();
		educationinfo.setBranch("CS");
		educationinfo.setCollegeName("bh vhbv");
		educationinfo.setEducationbean(edubean);
		
		
		EmployeeEducationInfoBean educationinfo1 = new EmployeeEducationInfoBean();
		educationinfo1.setBranch("EC");
		educationinfo1.setCollegeName("BVB");
		educationinfo1.setEducationbean(edubean1);
		
		
		ExperiencePKBean expbean = new ExperiencePKBean();
		expbean.setBean(bean);
		expbean.setCompany("Test Yantra");
		
		ExperiencePKBean expkbean = new ExperiencePKBean();
		expkbean.setBean(bean);
		expkbean.setCompany("E2");
		
		EmployeeExperienceInfoBean experiencebean = new EmployeeExperienceInfoBean();
		experiencebean.setDesignation("SD");
		experiencebean.setExpbean(expbean);
		
		EmployeeExperienceInfoBean experiencebean1 = new EmployeeExperienceInfoBean();
		experiencebean1.setDesignation("Senior");
		experiencebean1.setExpbean(expkbean);
		
		
		impl.creatEmployeeBean(bean, otherbean);//OneToOneMapping
		impl.creatManyToOne(Arrays.asList(addressbean,addressbean1), 
				Arrays.asList(educationinfo,educationinfo1),
				Arrays.asList(experiencebean, experiencebean1));
		
	}
	
	
}
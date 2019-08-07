package com.tyss.HibernateMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.tyss.HibernateMapping.hibernateimpl.HibernateImpl;
import com.tyss.HibernateMapping.manytomany.dto.TrainingInfoBean;
import com.tyss.HibernateMapping.onetoone.dto.EmpolyeeInfoBean;

public class ManyToManyRelationship {

	public static void main(String[] args) throws ParseException {
		//mant to many example
		    
				EmpolyeeInfoBean bean4 = new EmpolyeeInfoBean();
				SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd");
				bean4.setId(3);
				bean4.setName("Ashika");
				bean4.setAge(25);
				bean4.setAcno(12345678);
				//bean4.setDeptid(deptid);;
				bean4.setDesignation("Software engineer");
				bean4.setGender("Female");
				bean4.setEmail("ashi@gmail.com");
				//bean4.setManagerid(infobean);
				Date dob1=format1.parse("1994-04-01");
				bean4.setDob(dob1);
				
				EmpolyeeInfoBean bean5 = new EmpolyeeInfoBean();
				SimpleDateFormat format2=new SimpleDateFormat("yyyy-mm-dd");
				bean5.setId(2);
				bean5.setName("Ashika");
				bean5.setAge(25);
				bean5.setAcno(12345678);
				//bean5.setDeptid(102);
				bean5.setDesignation("Software engineer");
				bean5.setGender("Female");
				bean5.setEmail("ashi@gmail.com");
				//bean5.setManagerid(infobean);
				Date dob2=format2.parse("1994-04-01");
				bean5.setDob(dob1);
				
				//ManyToMany Mapping by getEmployee Id
				HibernateImpl impl1 = new HibernateImpl();
				EmpolyeeInfoBean  infobean =impl1.getEmpolyeeInfoBeanById(1);
				
				
				
				TrainingInfoBean traininginfobean = new TrainingInfoBean();
				traininginfobean.setCourseId(304);
				traininginfobean.setCourseType("F");
				traininginfobean.setCourseName("Java");
				//traininginfobean.setCourseId(111);
				traininginfobean.setInfobean(Arrays.asList(bean4,bean5, infobean));
				
				HibernateImpl impl = new HibernateImpl();
				
				impl.creatTraning(traininginfobean);

	}

}

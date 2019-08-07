package com.tyss.HibernateMapping.hibernateimpl;

import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tyss.HibernateMapping.dto.BidirectionalMappingBean;
import com.tyss.HibernateMapping.manytomany.dto.TrainingInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeAddressInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeEducationInfoBean;
import com.tyss.HibernateMapping.manytoone.dto.EmployeeExperienceInfoBean;
import com.tyss.HibernateMapping.onetoone.dto.EmployeeOtherInfoBean;
import com.tyss.HibernateMapping.onetoone.dto.EmpolyeeInfoBean;

public class HibernateImpl {

	private Configuration config = new Configuration();
	private SessionFactory factory = config.configure().buildSessionFactory();

	public void creatManyToOne(
			List<EmployeeAddressInfoBean> addressbean,
			List<EmployeeEducationInfoBean> educationbean,
			List<EmployeeExperienceInfoBean> experiencebean) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		
		for(EmployeeAddressInfoBean addressInfoBean:addressbean) {
			session.save(addressInfoBean);
		}
		for(EmployeeEducationInfoBean education :educationbean) {
			session.save(education);
		}
		for(EmployeeExperienceInfoBean expbean :experiencebean) {
			session.save(expbean);
		}
		txn.commit();
		session.close();
		
	}//ManyToone End Here
	
	public void creatEmployeeBean(EmpolyeeInfoBean bean,
			EmployeeOtherInfoBean otherbean) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(bean);
		session.save(otherbean);
		txn.commit();
		session.close();
		
	}
	public void creatTraning(TrainingInfoBean trainingbean) {
		Session session1 = factory.openSession();
		Transaction txn1 = session1.beginTransaction();
		
		
			session1.save(trainingbean);
		
		txn1.commit();
		session1.close();
	}
	
	//ManyToOne Mapping(MamgerID)
	public void creatEmployeeBean(EmpolyeeInfoBean bean) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.saveOrUpdate(bean);
		txn.commit();
		session.close();
				
	}
	
	public EmpolyeeInfoBean getEmpolyeeInfoBeanById(int id) {
		Session session = factory.openSession();
		EmpolyeeInfoBean bean= session.get(EmpolyeeInfoBean.class, id);
		session.close();
		return bean;
	}//End Here
	
	public void creatBidirectionalMappingBean(BidirectionalMappingBean bean) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.saveOrUpdate(bean);
		txn.commit();
		session.close();
				
	}
}

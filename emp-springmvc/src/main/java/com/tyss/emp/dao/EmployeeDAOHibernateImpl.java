package com.tyss.emp.dao;


import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.tyss.emp.dto.EmployeeInfoBean;



public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	@Autowired
	SessionFactory factory;
	public ArrayList<EmployeeInfoBean> getAllEmployeeInfo() {
		Session session=factory.openSession();
		Query query=session.createQuery("from EmployeeInfoBean");
		
		return (ArrayList<EmployeeInfoBean>) query.list();
	}

	
	public EmployeeInfoBean getEmployeeInfo(String id) {
		return getEmployeeInfo(Integer.parseInt(id));
	}

	
	public EmployeeInfoBean getEmployeeInfo(int id) {
		Session session = factory.openSession();
		EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);
		session.close();
		return bean;
	}

	private boolean SaveOrUpdate(EmployeeInfoBean bean) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(bean);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		return SaveOrUpdate(bean);
	}

	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		return SaveOrUpdate(bean);
	}

	public boolean deleteEmployeeInfo(int id) {
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			EmployeeInfoBean bean=session.get(EmployeeInfoBean.class, id);
			session.delete(bean);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmployeeInfo(String id) {
		return deleteEmployeeInfo(Integer.parseInt(id));
	}

	public ArrayList<EmployeeInfoBean> getEmployeeIds(int eid) {
		Session session=factory.openSession();
		Query query=session.createQuery("from EmployeeInfoBean b where str(b.id) LIKE '"+eid+"%'");
		
		return (ArrayList<EmployeeInfoBean>) query.list();
	}
	

}

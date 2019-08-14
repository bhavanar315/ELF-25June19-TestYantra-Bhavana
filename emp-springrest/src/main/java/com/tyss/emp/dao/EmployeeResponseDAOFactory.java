package com.tyss.emp.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResponseDAOFactory { 
	@Bean("Hibernate")
	public EmployeeResponseDAOHibernateImpl getHibernateInstance() {
		return new EmployeeResponseDAOHibernateImpl();
	}
	
	@Bean("jdbc")
	public EmployeeDAOJDBCImpl getJDBCInstance() {
		return new EmployeeDAOJDBCImpl();
	}
	
}

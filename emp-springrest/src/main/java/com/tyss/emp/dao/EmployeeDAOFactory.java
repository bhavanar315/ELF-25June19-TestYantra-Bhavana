package com.tyss.emp.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOFactory { 
	@Bean("hibernate")
	public EmployeeDAOHibernateImpl getHibernateInstance() {
		return new EmployeeDAOHibernateImpl();
	}
	
	@Bean("jdbc")
	public EmployeeDAOJDBCImpl getJDBCInstance() {
		return new EmployeeDAOJDBCImpl();
	}
	
}

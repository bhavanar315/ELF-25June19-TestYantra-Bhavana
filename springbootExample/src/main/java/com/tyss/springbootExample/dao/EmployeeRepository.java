package com.tyss.springbootExample.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tyss.springbootExample.dta.EmployeeInfoBean;
import com.tyss.springbootExample.dta.EmployeeOtherInfoBean;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean,Integer>{

	@Query("Select e from EmployeeOtherInfoBean e where e.bean=:id")
	public EmployeeOtherInfoBean findByEmployee(@Param("id") EmployeeInfoBean id);
	
	
}

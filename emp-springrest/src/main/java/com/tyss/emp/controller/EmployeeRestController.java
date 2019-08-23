package com.tyss.emp.controller;



import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.emp.dao.EmployeeDAO;
import com.tyss.emp.dto.EmployeeInfoBean;

@RestController
@RequestMapping("/employee")
@PropertySource("classpath:msg.properties")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeRestController {

	@Autowired
	@Qualifier("hibernate")
	EmployeeDAO dao;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
	  CustomDateEditor editor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

	@GetMapping(value="/getAllEmployee",  produces = {"application/json" })
	public  List<EmployeeInfoBean> getAllEmployee() {
		return dao.getAllEmployeeInfo();
	}
	
	@GetMapping("/getEmployee" )
	public  EmployeeInfoBean getEmployee(@RequestParam int id) {
		return dao.getEmployeeInfo(id);
	}
	
	@PostMapping(value="/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean addEmployee(@RequestBody EmployeeInfoBean bean) {
		
		return dao.createEmployeeInfo(bean);

	}
	@PutMapping(value="/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  boolean updateEmployee(@RequestBody EmployeeInfoBean bean) {
		
		return dao.updateEmployeeInfo(bean);

	}
	@DeleteMapping("/deleteEmployee")
	public  boolean deleteEmployee(@RequestParam int id) {
		
		return dao.deleteEmployeeInfo(id);

	}

}

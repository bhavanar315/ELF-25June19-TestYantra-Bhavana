package com.tyss.emp.controller;



import java.beans.Beans;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;


import com.tyss.emp.dao.EmployeeResponseDAO;
import com.tyss.emp.dto.EmployeeAddressInfoBean;
import com.tyss.emp.dto.EmployeeEducationInfoBean;
import com.tyss.emp.dto.EmployeeExperienceInfoBean;
import com.tyss.emp.dto.EmployeeInfoBean;
import com.tyss.emp.dto.EmployeeOtherInfoBean;
import com.tyss.emp.dto.EmployeeResponseBean;

@RestController
@RequestMapping("/employeeResponse")
@PropertySource("classpath:msg.properties")
public class EmployeeRestResponseController {

	@Autowired
	@Qualifier("Hibernate")
	EmployeeResponseDAO dao;
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
	  CustomDateEditor editor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

	@GetMapping(value="/getAllEmployee",  produces = {"application/json" })
	public  EmployeeResponseBean getAllEmployee( HttpServletRequest request) {
		List<EmployeeInfoBean> bean= dao.getAllEmployeeInfo();
		EmployeeResponseBean response= new EmployeeResponseBean();
		if(request.getSession(false)!=null) {
			if(bean!=null) {
				response.setStatusCode(201);
				response.setMessage("Sucessfully created");
				response.setDescription(" employee data found");
				response.setBeans(bean);
			}else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Failure to find employee data");
				
			}
			return response;
		}else{
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
		}
		
		
	}
	
	@GetMapping("/getEmployee" )
	public  EmployeeResponseBean getEmployee(@RequestParam int id, HttpServletRequest request) {
		
		EmployeeResponseBean response= new EmployeeResponseBean();
		if(request.getSession(false)!=null) {
			EmployeeInfoBean bean= dao.getEmployeeInfo(id);
			if(bean!=null) {
				response.setStatusCode(201);
				response.setMessage("Sucessfully");
				response.setDescription(" employee data found");
				response.setBeans(Arrays.asList(bean));
			}else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Failure to find employee data");
				
			}
			return response;
		}else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
		}
		
	}
	
	@PostMapping(value="/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponseBean addEmployee(@RequestBody EmployeeInfoBean bean) {
		
		EmployeeResponseBean response = new EmployeeResponseBean();
		
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressbean()) {
			addressInfoBean.getAddressPkBean().setBean(bean);
		}
		for (EmployeeEducationInfoBean education : bean.getEducationbean()) {
			education.getEducationbean().setBean(bean);
		}
		for (EmployeeExperienceInfoBean expbean : bean.getExperiencebean()) {
			expbean.getExpbean().setBean(bean);
		}
		EmployeeOtherInfoBean otherinfo = bean.getOtherbean();
		otherinfo.setBean(bean);
		
		if( dao.createEmployeeInfo(bean)) {
			response.setStatusCode(201);
			response.setMessage("Sucessfully created");
			response.setDescription("Successfully employee created");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed to created");
			response.setDescription("Failed to create employee data");
		}
		return response;

	}
	@PutMapping(value="/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponseBean updateEmployee(@RequestBody EmployeeInfoBean bean, HttpServletRequest request) {
		EmployeeResponseBean response = new EmployeeResponseBean();
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressbean()) {
			addressInfoBean.getAddressPkBean().setBean(bean);
		}
		for (EmployeeEducationInfoBean education : bean.getEducationbean()) {
			education.getEducationbean().setBean(bean);
		}
		for (EmployeeExperienceInfoBean expbean : bean.getExperiencebean()) {
			expbean.getExpbean().setBean(bean);
		}
		EmployeeOtherInfoBean otherinfo = bean.getOtherbean();
		otherinfo.setBean(bean);
		if(request.getSession(false)!=null) {
			if( dao.updateEmployeeInfo(bean)) {
				response.setStatusCode(201);
				response.setMessage("Sucessfully updated");
				response.setDescription("Successfully updated employee data");
			}else {
				response.setStatusCode(401);
				response.setMessage("Failed to created");
				response.setDescription("Failed to create employee data");
			}
			return response;

		}else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
		}
		
	}
	@DeleteMapping("/deleteEmployee")
	public  EmployeeResponseBean deleteEmployee(@RequestParam int id, HttpServletRequest request) {
		EmployeeResponseBean response = new EmployeeResponseBean();
		if(request.getSession(false)!=null) {
			if( dao.deleteEmployeeInfo(id)) {
				response.setStatusCode(201);
				response.setMessage("Sucessfully deleted");
				response.setDescription("Successfully delete employee data");
			}else {
				response.setStatusCode(401);
				response.setMessage("Failed to delete");
				response.setDescription("Failed to delete employee data");
			}
			return response;	
		}else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;	
		}
		

	}

}

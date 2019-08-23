package com.tyss.springbootExample.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springbootExample.dao.EmployeeRepository;
import com.tyss.springbootExample.dta.EmployeeAddressInfoBean;
import com.tyss.springbootExample.dta.EmployeeEducationInfoBean;
import com.tyss.springbootExample.dta.EmployeeExperienceInfoBean;
import com.tyss.springbootExample.dta.EmployeeInfoBean;
import com.tyss.springbootExample.dta.EmployeeOtherInfoBean;
import com.tyss.springbootExample.dta.EmployeeResponseBean;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping(path="/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String Helloworld() {
		return"Hello";
	}
	
	@GetMapping(value="/getAllEmployee",  produces = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponseBean getAllEmployee(HttpServletRequest request) {
		
		List<EmployeeInfoBean> bean= (List<EmployeeInfoBean>) repository.findAll();
		EmployeeResponseBean response = new EmployeeResponseBean();
		if(request.getSession(false)!=null) {
			 if(bean!=null) {
				   response.setStatusCode(201);
					response.setMessage("Sucessfully");
					response.setDescription("Successfully found employee data");
					response.setBeans(bean);
				 
			 }else {
				 response.setStatusCode(401);
					response.setMessage("Failed");
					response.setDescription("dailed to find employee data");
			 }
			 return response;
		}else{
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
			
		}
		
	}
	
	@GetMapping(path="/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponseBean getEmployee(@RequestParam int id, HttpServletRequest request) {
		 EmployeeResponseBean response = new EmployeeResponseBean();
		 if(request.getSession(false)!=null) {
			 if(repository.existsById(id)) {
				 EmployeeInfoBean bean= repository.findById(id).get();
				   response.setStatusCode(201);
					response.setMessage("Sucessfully");
					response.setDescription("Successfully employee created");
					response.setBeans(Arrays.asList(bean));
			 }else {
				 response.setStatusCode(401);
					response.setMessage("Failed");
					response.setDescription("Successfully employee created");
			 }
			 return response;
		 }else {
			 response.setStatusCode(501);
				response.setMessage("Failure");
				response.setDescription("Please login first");
				return response;
		 }
	}
	
	public void addOrupdateEmployee(@RequestBody EmployeeInfoBean bean) {
			for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressbean()) {
				addressInfoBean.getAddressPkBean().setBean(bean);
				bean.setAddressbean(Arrays.asList(addressInfoBean));
			}
			for (EmployeeEducationInfoBean education : bean.getEducationbean()) {
				education.getEducationbean().setBean(bean);
				bean.setEducationbean(Arrays.asList(education));
			}
			for (EmployeeExperienceInfoBean expbean : bean.getExperiencebean()) {
				expbean.getExpbean().setBean(bean);
				bean.setExperiencebean(Arrays.asList(expbean));
			}
			EmployeeInfoBean manger=bean.getManagerid();
			if(manger!=null) {
				manger=repository.findById(manger.getId()).get();
				bean.setManagerid(manger);
			}
	}
	
	@PostMapping(path="/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponseBean addEmployee(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponseBean response = new EmployeeResponseBean();
		EmployeeOtherInfoBean otherinfo = bean.getOtherbean();
		otherinfo.setBean(bean);
		bean.setOtherbean(otherinfo);
        addOrupdateEmployee(bean);
		if(!repository.existsById(bean.getId())) {
			repository.save(bean);
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
		//to get otherinfobean primary key and set it for update
		// EmployeeInfoBean otherId= repository.findById(bean.getId()).get();
		// bean.getOtherbean().setOtherId(otherId.getOtherbean().getOtherId());
		
		if(request.getSession(false)!=null) {
			if(repository.existsById(bean.getId())) {
				addOrupdateEmployee(bean);
				bean.getOtherbean().setOtherId(repository
						.findByEmployee(bean)
						.getOtherId());
				repository.save(bean);
				response.setStatusCode(201);
				response.setMessage("Sucessfully updated");
				response.setDescription("Successfully employee updated");
			}else {
				response.setStatusCode(401);
				response.setMessage("Failed to update");
				response.setDescription("Failed to update employee data");
			}
			return response;
			
		}else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
			
		}
	}
	
	@GetMapping(path="/getotherinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeOtherInfoBean getOtherinfo(int id) {
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id); 
		return repository.findByEmployee(bean);
	}
	
	  @DeleteMapping(path="/deleteEmployee", produces = MediaType.APPLICATION_JSON_VALUE) 
	  public EmployeeResponseBean deleteEmployee(@RequestParam int id, HttpServletRequest request) {
	  
	  EmployeeResponseBean response = new EmployeeResponseBean();
	  Optional<EmployeeInfoBean> bean = repository.findById(id);
	  if(request.getSession(false)!=null) {
		  
		  if(bean!=null){
			  repository.deleteById(id);
			  response.setStatusCode(201); 
			  response.setMessage("Sucessfully deleted");
			  response.setDescription("Successfully delete employee data");
		  }else{
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

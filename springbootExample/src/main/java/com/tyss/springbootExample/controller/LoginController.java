package com.tyss.springbootExample.controller;



import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springbootExample.dao.EmployeeRepository;
import com.tyss.springbootExample.dta.EmployeeInfoBean;
import com.tyss.springbootExample.dta.EmployeeResponseBean;



@RestController

@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	EmployeeRepository repository;


	
	@PostMapping(value="/login", produces =MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponseBean login(int id, String password,
			HttpServletRequest request) {
		
		EmployeeInfoBean bean = repository.findById(id).get();
		EmployeeResponseBean response = new EmployeeResponseBean();
		if(repository.existsById(bean.getId())) {
			if(bean != null && bean.getPassword().equals(password)) {
				response.setStatusCode(200);
				response.setMessage("Sucessfully");
				response.setDescription("employee logged Sucessfully");
				response.setBeans(Arrays.asList(bean));
				request.getSession().setAttribute("bean", bean);;
			}else {
				response.setStatusCode(501);
				response.setMessage("failed");
				response.setDescription(" failed to login, try Again");
			}
			return response;
		}else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please create Employee");
			return response;
		}
		
	}
	
	@GetMapping(value="/logout", produces =MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponseBean logout(HttpSession session) {
		session.invalidate();
		EmployeeResponseBean response= new EmployeeResponseBean();
		response.setStatusCode(101);
		response.setMessage("Sucessfully ");
		response.setDescription(" Sucessfully logged out");
		return response;
	}
	@GetMapping(value="/readcookie", produces =MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponseBean readCookie(@CookieValue(name="JSESSIONID") String  sessionId) {
		EmployeeResponseBean response= new EmployeeResponseBean();
		response.setStatusCode(101);
		response.setMessage("Sucessfully ");
		response.setDescription("JSESSIONID:" +sessionId);
	
		return response;
	}

	
	
}

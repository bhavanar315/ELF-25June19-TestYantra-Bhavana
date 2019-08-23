package com.tyss.LMS.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tyss.LMS.dto.ResponseBean;

import com.tyss.LMS.services.LibraryServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
	
	@Autowired
	LibraryServiceImpl libraryservice;

	@PostMapping(value="/login", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean login(String email, String password, HttpServletRequest request) {
		
		return libraryservice.userLogin(email, password, request);
		
	}
	
	@GetMapping(value="/logout", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean logout(HttpSession session) {
		session.invalidate();
		ResponseBean response= new ResponseBean();
		response.setStatusCode(101);
		response.setMessage("Sucessfully");
		response.setDescription(" Sucessfully logged out");
		return response;
	}
	
	
}

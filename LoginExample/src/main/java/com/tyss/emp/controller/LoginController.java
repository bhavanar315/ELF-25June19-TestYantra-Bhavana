package com.tyss.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.tyss.emp.common.ConstantValue.*;
//import static com.tyss.emp.common.ConstantValue.VIEW_HOME_PAGE;
//import static com.tyss.emp.common.ConstantValue.VIEW_LOGIN_PAGE;


import lombok.extern.java.Log;

@Log
@PropertySource(PROP_FILE)
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/loginform")
	public String LoginForm() {
		return VIEW_LOGIN_PAGE;
	}
	
	
	@PostMapping("/authenticate")
	public String getLogin(String userName, int password, HttpServletRequest req) {
		
		if(userName.equals("bhavana") && password==101) {
			HttpSession session = req.getSession();
			session.setAttribute("username", userName);
			return VIEW_HOME_PAGE;
			
		}
		
		return VIEW_LOGIN_PAGE;
	}
	
	@GetMapping("/logout")
	public String LogoutForm(HttpSession session, ModelMap map, 
			@Value("${logoutmsg}")  String logoutmsg) {
		
		map.addAttribute("msg", logoutmsg);
		return VIEW_LOGIN_PAGE;
	}
	
	

}

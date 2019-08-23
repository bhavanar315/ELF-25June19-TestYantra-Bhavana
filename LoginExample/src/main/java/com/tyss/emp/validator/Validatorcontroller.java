package com.tyss.emp.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.tyss.emp.common.ConstantValue.*;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/validator")
public class Validatorcontroller {
	
	@GetMapping("/validate/{url1}/{url2}")
	public String validate(HttpServletRequest req,
			@PathVariable("url1") String url1,
			@PathVariable("url2") String url2,
			String msg) {
		if(req.getSession(false)==null) {
			req.setAttribute("name", msg);
			return VIEW_LOGIN_PAGE;
			
		}
		return "forward:"+url1+"/"+url2;
	}
	
	@PostMapping("/validate/{url1}/{url2}")
	public String validatePost(HttpServletRequest req,
			@PathVariable("url1") String url1,
			@PathVariable("url2") String url2,
			String msg) {
		if(req.getSession(false)==null) {
			req.setAttribute("name", msg);
			return VIEW_LOGIN_PAGE;
			
		}
		return "forward:/"+url1+"/"+url2;
	}

}

package com.tyss.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delegate")
public class RequestDelegationController {
	@GetMapping("/getRequest")
	public String getRequestPage() {
		return "request";
	}
	@GetMapping("/forwardReq")
	public String forwardRequest() {
		return "forward:/employee/getForm";
	}
	@GetMapping("/redirectReq")
	public String includeRequest() {
		return "redirect:https://www.google.com";
	}
}

package com.tyss.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class SessionController {
	@GetMapping("/login")
	public String login() {
		return null;
	}
}

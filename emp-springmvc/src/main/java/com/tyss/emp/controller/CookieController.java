package com.tyss.emp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	@GetMapping("/getCookie")
	public String getCookie() {
		return "cookiePage";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp,ModelMap map) {
		Cookie cookie=new Cookie("name", "New");
		resp.addCookie(cookie);
		map.addAttribute("msg","Cookie created");
		return "cookiePage";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue(name="name") String name,ModelMap map) {
		
		map.addAttribute("msg",name);
		return "cookiePage";
	}
}

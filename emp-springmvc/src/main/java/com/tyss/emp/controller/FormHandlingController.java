package com.tyss.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.emp.dto.UserBean;

@Controller
@RequestMapping("/forms")
public class FormHandlingController {
	@GetMapping("/getForm")
	public String getForm() {
		return "loginForm";
	}
	
	@PostMapping("/formSubmit")
	public String submitForm(HttpServletRequest req) {
		int id=Integer.parseInt(req.getParameter("id"));
		String password=req.getParameter("password");
		req.setAttribute("id", id);
		req.setAttribute("password", password);
		return "formDataDisplay";
	}
	
	@PostMapping("/formSubmit2")
	public String submitForm2(int id,String password,ModelMap map) {
		
		map.addAttribute("id", id);
		map.addAttribute("password", password);
		return "formDataDisplay";
	}
	
	@PostMapping("/formSubmit3")
	public String submitForm3(UserBean userBean,ModelMap map) {
		map.addAttribute("userBean", userBean);
		return "formDataBeanDisplay";
	}
	
	@PostMapping("/formSubmit4")
	public String submitForm4(@RequestParam(name="id") int userId,@RequestParam(name="password") String pass,ModelMap map) {
		map.addAttribute("id", userId);
		map.addAttribute("password", pass);
		return "formDataBeanDisplay";
	}
	@PostMapping("/formSubmit5")
	public String submitForm5(@RequestParam(name="id") int userId,@RequestParam(name="password") String pass,ModelMap map) {
		map.addAttribute("id", userId);
		map.addAttribute("password", pass);
		return "formDataDisplayEL";
	}
	@PostMapping("/formSubmit6")
	public String submitForm6(UserBean bean,ModelMap map) {
		map.addAttribute("bean", bean);
		return "formDataBeanDisplayEL";
	}
}

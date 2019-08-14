 package com.tyss.emp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.emp.dao.EmployeeDAO;
import com.tyss.emp.dao.EmployeeDAOHibernateImpl;
import com.tyss.emp.dto.EmployeeInfoBean;

@Controller
@RequestMapping("/employeeOld")
@PropertySource("classpath:msg.properties")
public class EmployeeControllerOld {
	  
	@InitBinder
	    public void initBinder(WebDataBinder binder) {
		  CustomDateEditor editor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	        binder.registerCustomEditor(Date.class, editor);
	    }

	
	  @Autowired
	  @Qualifier("hibernate")
	  EmployeeDAO dao;
	 
	@RequestMapping(path = "/getMsg",method = RequestMethod.GET)
	public ModelAndView getMessage() {
		ModelAndView modelAndView=new ModelAndView();
		//modelAndView.setViewName("../WEB-INF/views/messagePage.jsp");
		modelAndView.setViewName("messagePage");
		return modelAndView;
	}
	@GetMapping("/getMessage")
	public ModelAndView getMessage(ModelAndView modelAndView) {
		//modelAndView.setViewName("../WEB-INF/views/messagePage.jsp");
		modelAndView.setViewName("messagePage");
		return modelAndView;
	}
	
	@GetMapping("/getForm")
	public String getForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String submitLoginForm(int id,String password,HttpServletRequest req,ModelMap map,@Value("${loginFail}") String msg) {
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		if(bean !=null && bean.getPassword().equals(password)) {
			HttpSession session=req.getSession(true);
			session.setAttribute("bean", bean);
		return "home";
		}
		else {
			map.addAttribute("msg", msg);
			return "loginForm";
		}
	}
	@GetMapping("/search")
	public String searchEmployeeById(int id,ModelMap map) {
		ArrayList<EmployeeInfoBean> arrId = dao.getEmployeeIds(id);
		
		if(arrId !=null) {
			map.addAttribute("ArrayIds",arrId);
			return "searchEmployee";
		}else {
			map.addAttribute("msg","No employee Found");
			return "home";
		}
	}
	@GetMapping("/fetch")
	public String getEmployeeDetails(int emp,ModelMap map) {
		EmployeeInfoBean bean = dao.getEmployeeInfo(emp);
		map.addAttribute("bean", bean);
		return "home";
		
	}
	@GetMapping("/logout")
	public String logoutFun(ModelMap map,HttpSession session,@Value("${logout}") String msg) {		
		session.invalidate();
		map.addAttribute("msg",msg);
		return "loginForm";
	}
	@GetMapping("/createEmployee")
	public String getCreateEmployeePage() {
		return "createEmployee";
	}
	@PostMapping("/create")
	public String createEmployee(@ModelAttribute(name="empModel") EmployeeInfoBean bean,ModelMap map) {
		if(dao.createEmployeeInfo(bean)) {
		map.addAttribute("msg", "Employee Account Created Successfully");
		return "loginForm";
		}else {
			map.addAttribute("msg", "Error Try Again");
			return "loginForm";
		}
		
	}
	
	@GetMapping("/validate")
	public String validateSession(HttpServletRequest req,ModelMap map,
			@RequestParam("url") String url) {
		if(req.getSession(false)==null) {
			map.addAttribute("msg", "Please login first");
			return "loginForm";
		}
		return "forward:/employee/"+url;
	}
	
	@GetMapping("/validateDemo")
	public String validateSession(HttpSession session,ModelMap map,@RequestParam("url") String url) {
		if(session.isNew()) {
			map.addAttribute("msg", "Please login first");
			session.invalidate();
			return "loginForm";
		}
		return "forward:/employee/"+url;
	}
	
	@PostMapping("/validate")
	public String validateSessionForPost(HttpServletRequest req,ModelMap map,@RequestParam("url") String url) {
		return validateSession(req,map,url);
	}
	
	@GetMapping("/validate1/{url}")
	public String validateSessionPath(HttpServletRequest req,ModelMap map,
			@PathVariable("url") String url) {
		if(req.getSession(false)==null) {
			map.addAttribute("msg", "Please login first");
			return "loginForm";
		}
		return "forward:/employee/"+url;
	}
	
	@GetMapping("/validateDemo1/{url}")
	public String validateSessionPath(HttpSession session,ModelMap map,@PathVariable("url") String url) {
		if(session.isNew()) {
			map.addAttribute("msg", "Please login first");
			session.invalidate();
			return "loginForm";
		}
		return "forward:/employee/"+url;
	}
	
	@PostMapping("/validate1/{url}")
	public String validateSessionForPostPath(HttpServletRequest req,ModelMap map,@PathVariable("url") String url) {
		return validateSessionPath(req,map,url);
	}
}

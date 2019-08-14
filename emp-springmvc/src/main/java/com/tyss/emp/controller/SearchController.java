package com.tyss.emp.controller;

import static com.tyss.emp.commons.EMPConstants.VIEW_HOME_PAGE;
import static com.tyss.emp.commons.EMPConstants.VIEW_SEARCH_EMPLOYEE;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyss.emp.dao.EmployeeDAO;
import com.tyss.emp.dto.EmployeeInfoBean;

import lombok.extern.java.Log;


@Log
@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	  @Qualifier("hibernate")
	  EmployeeDAO dao;
	 
	@GetMapping("/searchEmp")
	public String searchEmployeeById(int id,ModelMap map,@Value("${EmpNotFound}") String msg) {
		ArrayList<EmployeeInfoBean> arrId = dao.getEmployeeIds(id);
		log.info("Inside Emp Search");
		if(arrId !=null) {
			map.addAttribute("ArrayIds",arrId);
			return VIEW_SEARCH_EMPLOYEE;
		}else {
			map.addAttribute("msg",msg);
			return VIEW_HOME_PAGE;
		}
	}
	
	@GetMapping("/fetch")
	public String getEmployeeDetails(int emp,ModelMap map) {
		EmployeeInfoBean bean = dao.getEmployeeInfo(emp);
		map.addAttribute("bean", bean);
		return VIEW_HOME_PAGE;
		
	}
	
	
}

package com.tyss.emp.controller;

import static com.tyss.emp.commons.EMPConstants.DB_INTERACTION_TYPE;
import static com.tyss.emp.commons.EMPConstants.FORWARD_REQUEST;
import static com.tyss.emp.commons.EMPConstants.PROP_FILENAME;
import static com.tyss.emp.commons.EMPConstants.VIEW_CREATE_EMPLOYEE_PROFILE;
import static com.tyss.emp.commons.EMPConstants.VIEW_HOME_PAGE;
import static com.tyss.emp.commons.EMPConstants.VIEW_LOGIN_PAGE;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.emp.dao.EmployeeDAO;
import com.tyss.emp.dto.EmployeeAddressInfoBean;
import com.tyss.emp.dto.EmployeeEducationInfoBean;
import com.tyss.emp.dto.EmployeeExperienceInfoBean;
import com.tyss.emp.dto.EmployeeInfoBean;
import com.tyss.emp.dto.EmployeeResponseBean;

@RestController
@RequestMapping("/login")
@PropertySource(PROP_FILENAME)
public class LoginController {

	@Autowired
	@Qualifier(DB_INTERACTION_TYPE)
	EmployeeDAO dao;

	@GetMapping("/loginPage")
	public String getForm() {
		return VIEW_LOGIN_PAGE;
	}
	
	@PostMapping(value="/login", produces =MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponseBean login(int id, String password,
			HttpServletRequest request) {
		
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		EmployeeResponseBean response = new EmployeeResponseBean();
		if(bean != null && bean.getPassword().equals(password)) {
			response.setStatusCode(201);
			response.setMessage("Sucessfully ");
			response.setDescription(" employee logged Sucessfully");
			response.setBeans(Arrays.asList(bean));
			request.getSession().setAttribute("bean", bean);;
		}else {
			response.setStatusCode(201);
			response.setMessage("failed");
			response.setDescription(" failed to login, try Again");
		}
		return response;
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

	@PostMapping("/authenticate")
	public String submitLoginForm(int id, String password, HttpServletRequest req, @Value("${loginFail}") String msg) {

		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		if (bean != null && bean.getPassword().equals(password)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("bean", bean);
			return VIEW_HOME_PAGE;
		} else {
			req.setAttribute("msg", msg);
			return VIEW_LOGIN_PAGE;
		}
	}

	@GetMapping("/createEmployee")
	public String createEmployeePage() {
		return VIEW_CREATE_EMPLOYEE_PROFILE;
	}

	/*
	 * @PostMapping("/Create") public String creatEmployeeBean(EmployeeInfoBean
	 * bean, int mgrId, ModelMap map) {
	 * 
	 * EmployeeInfoBean mngId = dao.getEmployeeInfo(mgrId);
	 * bean.setManagerid(mngId);
	 * 
	 * for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressbean()) {
	 * addressInfoBean.getAddressPkBean().setBean(bean); } for
	 * (EmployeeEducationInfoBean education : bean.getEducationbean()) {
	 * education.getEducationbean().setBean(bean); } for (EmployeeExperienceInfoBean
	 * expbean : bean.getExperiencebean()) { expbean.getExpbean().setBean(bean); }
	 * if (dao.createEmployeeInfo(bean)) { map.addAttribute("msg",
	 * "Employee created sucessfully"); return "VIEW_LOGIN_PAGE"; } else {
	 * map.addAttribute("msg", "Error try Again"); return "VIEW_LOGIN_PAGE"; } }
	 */

	
}

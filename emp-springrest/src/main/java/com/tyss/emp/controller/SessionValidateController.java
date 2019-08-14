package com.tyss.emp.controller;

import static com.tyss.emp.commons.EMPConstants.FORWARD_REQUEST;
import static com.tyss.emp.commons.EMPConstants.PROP_FILENAME;
import static com.tyss.emp.commons.EMPConstants.VIEW_LOGIN_PAGE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
@PropertySource(PROP_FILENAME)
@RequestMapping("/validator")
public class SessionValidateController {
	@GetMapping("/validate/{url1}/{url2}")
	public String validateSessionPath(HttpServletRequest req, ModelMap map, @PathVariable("url1") String url1,
			@PathVariable("url2") String url2, @Value("${SessionExpireMsg}") String msg) {
		if (req.getSession(false) == null) {
			map.addAttribute("msg", msg);
			return VIEW_LOGIN_PAGE;
		}
		return FORWARD_REQUEST + url1 + "/" + url2;
	}

	@PostMapping("/validate/{url}")
	public String validateSessionForPostPath(HttpServletRequest req, ModelMap map, @PathVariable("url1") String url1,
			@PathVariable("url2") String url2, @Value("${SessionExpireMsg}") String msg) {
		return validateSessionPath(req, map, url1, url2, msg);
	}
}

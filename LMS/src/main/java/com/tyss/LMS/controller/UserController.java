package com.tyss.LMS.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.tyss.LMS.dto.ResponseBean;
import com.tyss.LMS.dto.UserDetails;
import com.tyss.LMS.services.LibraryServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	LibraryServiceImpl userservice;

	@PostMapping(path = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean createUserDetails(@RequestBody UserDetails user, HttpServletRequest request) {
		return userservice.createUser(user, request);
	}

	@GetMapping(path = "/search")
	public ResponseBean findByName(@RequestParam String name) {
		return userservice.findUserByUserNameStartingWith(name);
	}
	@GetMapping(path = "/getUser")
	public ResponseBean getUserByUserId(@RequestParam int userId, HttpServletRequest request) {
		return userservice.getUserByUserId(userId,request);
	}
	
	
	@GetMapping(path = "/getAllUser")
	public ResponseBean getAllUser( HttpServletRequest request) {
		return userservice.getAllUser();
	}
	

	@PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateEmployee(@RequestBody UserDetails user, HttpServletRequest request) {
		return userservice.updateUser(user, request);
	}

	@PutMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean deleteUser(@RequestParam int userId, HttpServletRequest request) {

		return userservice.deleteUser(userId, request);

	}
	

}

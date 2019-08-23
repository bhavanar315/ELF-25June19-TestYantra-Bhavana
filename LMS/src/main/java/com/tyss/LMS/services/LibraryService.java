package com.tyss.LMS.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.tyss.LMS.dto.Book;
import com.tyss.LMS.dto.ResponseBean;
import com.tyss.LMS.dto.UserDetails;
@Service
public interface LibraryService {
	public ResponseBean userLogin(String email,String password, HttpServletRequest request);
	public ResponseBean createUser(UserDetails user, HttpServletRequest request);
	public ResponseBean updateUser(UserDetails user, HttpServletRequest request);
	public ResponseBean getAllUser();
	public ResponseBean deleteUser(int userId, HttpServletRequest request);
	public ResponseBean findUserByUserNameStartingWith(String firstName);
	public ResponseBean getUserByUserId(int userId, HttpServletRequest request);
	
	
	
	
	
	
	
}

package com.tyss.LMS.services;

import java.util.Arrays;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.LMS.Repository.UserRepository;
import com.tyss.LMS.dto.ResponseBean;
import com.tyss.LMS.dto.UserDetails;


@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseBean userLogin(String email, String password, HttpServletRequest request) {
		UserDetails user = userRepository.findByEmail(email);
		System.out.println(""+user);
		ResponseBean response = new ResponseBean();
		//if (userRepository.existsById(user.getUserId())) {
			if (user!=null && user.getPassword().equals(password)) {
				response.setStatusCode(200);
				response.setMessage("Sucessfully");
				response.setDescription("User logged Sucessfully");
				response.setUser(Arrays.asList(user));
				request.getSession().setAttribute("user", user);

			} else {

				response.setStatusCode(501);
				response.setMessage("failed");
				response.setDescription(" failed to login, try Again");

			}
			return response;
		/*
		 * } else {
		 * 
		 * response.setStatusCode(501); response.setMessage("Failure"); response.
		 * setDescription("Please rquest Library admin to create login permission");
		 * return response;
		 * 
		 * }
		 */
	}

	@Override
	public ResponseBean createUser(UserDetails user, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();
		String name = user.getFirstName().substring(0, 2);
		user.setPassword(name+(int)(Math.random()*999999));
		user.setUserStatus("Active");
		//if (request.getSession(false) != null) {
			if (!userRepository.existsById(user.getUserId())) {
				//System.out.println("user"+user.getUserId());
				userRepository.save(user);
				response.setStatusCode(201);
				response.setUser(Arrays.asList(user));
				response.setMessage("Sucessfully");
				response.setDescription("Successfully User created");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed to create User");
				response.setDescription("Failed to create User data");
			}
			return response;
		/*
		 * }else { response.setStatusCode(501); response.setMessage("Failure");
		 * response.setDescription("Please login first"); return response; }
		 */

		
	}

	@Override
	public ResponseBean deleteUser(int userId, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();
		UserDetails user = userRepository.findById(userId).get();
		//if (request.getSession(false) != null) {
			if (user != null) {
				user.setUserStatus("Deactive");
				userRepository.save(user);
				response.setStatusCode(201);
				response.setMessage("Sucessfully deleted");
				response.setDescription("Successfully deactiveted the user");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed to delete");
				response.setDescription("Failed to delete employee data");
			}
			return response;
		/*
		 * } else { response.setStatusCode(501); response.setMessage("Failure");
		 * response.setDescription("Please login first"); return response; }
		 */
	}

	@Override
	public ResponseBean updateUser(UserDetails user, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();

		//if (request.getSession(false) != null) {
			if (userRepository.existsById(user.getUserId())) {
				userRepository.save(user);
				response.setStatusCode(201);
				response.setMessage("Sucessfully");
				response.setDescription("Successfully User updated");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed to update");
				response.setDescription("Failed to update User data");
			}
			return response;

		/*} else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;

		}*/

	}

	@Override
	public ResponseBean findUserByUserNameStartingWith(String firstName) {
		ResponseBean response = new ResponseBean();
		List<UserDetails> user = userRepository.findBySearchTerm(firstName);
		return response;
	}

	@Override
	public ResponseBean getUserByUserId(int userId, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();
		if (request.getSession(false) != null) {
			if (userRepository.existsById(userId)) {
				UserDetails user = userRepository.findById(userId).get();
				response.setStatusCode(201);
				response.setMessage("Sucessfully");
				response.setDescription("Successfully found User Details by userId");
				response.setUser(Arrays.asList(user));
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Failed find User Details by userId");
			}
			return response;
		} else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
		}
	}
	@Override
	public ResponseBean getAllUser() {
		ResponseBean response = new ResponseBean();
		List<UserDetails> user= (List<UserDetails>) userRepository.findAll();
		if(user!=null) {
			response.setStatusCode(201);
			response.setMessage("Sucessfully");
			response.setDescription("Successfully found User Details");
			response.setUser(user);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed find User Details");
		}
		return response;
	}

}

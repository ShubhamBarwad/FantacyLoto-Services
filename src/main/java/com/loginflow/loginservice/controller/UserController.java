package com.loginflow.loginservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginflow.loginservice.model.User;
import com.loginflow.loginservice.service.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public String addUser(@RequestParam Map<String, String> param) throws Exception {
		String username = param.get("username");
		String password = param.get("password");
		
		User user = User.builder()
				.username(username)
				.password(password)
				.build();
		boolean userAdded = userService.registerUser(user);
		if(!userAdded) {
			return "Could not Add User";
		}
		return "User Added Successfully";
	}
	
	@PostMapping("/login")
	public User login(@RequestParam Map<String, String> param) throws Exception {
		System.out.println("Login Endpoint hit");
		String username = param.get("username");
		String password = param.get("password");
		System.out.println(username);
		System.out.println(password);
		
		User user = User.builder()
					.username(username)
					.password(password)
					.build();
		user = userService.loginUser(user);
		if(user == null) {
			return null;
		}
		System.out.println(user);
		return user;
	}
	
}

package com.loginflow.loginservice.service;

import com.loginflow.loginservice.model.User;

public interface UserService {

	boolean registerUser(User user) throws Exception;

	User loginUser(User user) throws Exception;
	
}

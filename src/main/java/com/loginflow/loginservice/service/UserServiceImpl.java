package com.loginflow.loginservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginflow.loginservice.entity.UserEntity;
import com.loginflow.loginservice.model.User;
import com.loginflow.loginservice.repository.UserEntityRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserEntityRepository userEntityRepository;

	@Override
	public boolean registerUser(User user) throws Exception {
		try {
			UserEntity userEntity = new UserEntity();
			BeanUtils.copyProperties(user, userEntity);
			userEntity = userEntityRepository.save(userEntity);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public User loginUser(User user) throws Exception {
		User loggedInUser = new User();
		try {
			UserEntity userEntity = userEntityRepository.findByUsername(user.getUsername());
			if(userEntity.getPassword().equals(user.getPassword())) {
				BeanUtils.copyProperties(userEntity, loggedInUser);
			}else return null;
		}catch(Exception e){
			return null;
		}
		return loggedInUser;
	}

}

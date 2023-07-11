package com.loginflow.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginflow.loginservice.entity.UserEntity;
import com.loginflow.loginservice.model.User;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
	public UserEntity findByUsername(String username);
}

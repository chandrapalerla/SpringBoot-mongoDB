package com.springbootmongodb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.springbootmongodb.model.User;

public interface UserService {

	ResponseEntity<Object> saveUserDails(User user);

	MappingJacksonValue findAllUsers();
	
	ResponseEntity<Object> updateUser(User user);

	ResponseEntity<User> findUserById(long userId);
	
	void deleteUserById(long userId);
}

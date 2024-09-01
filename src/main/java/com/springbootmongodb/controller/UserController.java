package com.springbootmongodb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodb.model.User;
import com.springbootmongodb.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@RequestMapping(method = RequestMethod.POST, path = "/saveUser")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		return service.saveUserDails(user);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/findAllUsers")
	public MappingJacksonValue findAllUsers() {
		return service.findAllUsers();
	}


	@RequestMapping(method = RequestMethod.PUT,path = "/updateUser")
	public ResponseEntity<Object> updateUser(@Validated @RequestBody User user) {
		return service.updateUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/findUserById/{UserId}")
	public ResponseEntity<User> findUserById(@PathVariable("UserId") long userId){
		return service.findUserById(userId);
	}
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteUserById/{id}")
	public void deleteuserById(@PathVariable("id") long userId){
		service.deleteUserById(userId);
	}
}

package com.springbootmongodb.serviceImpl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springbootmongodb.daoimpl.UserDaoImpl;
import com.springbootmongodb.exception.UserNotFoundException;
import com.springbootmongodb.model.User;
import com.springbootmongodb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;

	@Override
	public ResponseEntity<Object> saveUserDails(User user) {
		User saveUser = dao.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{/id}")
				.buildAndExpand(saveUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public MappingJacksonValue findAllUsers() {
		List<User> findAllUsers = dao.findAllUsers();
		SimpleBeanPropertyFilter simpleBeanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("email","dateOfBirth");
		FilterProvider filter = new SimpleFilterProvider().addFilter("userFilter", simpleBeanFilter);
		MappingJacksonValue userFilter = new MappingJacksonValue(findAllUsers);
		userFilter.setFilters(filter);
		//return new ResponseEntity<List<User>>((List<User>) userFilter, HttpStatus.OK);
		return userFilter;
	}

	@Override
	public ResponseEntity<Object> updateUser(User user) {
		User updateUser = dao.updateUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{/id}")
				.buildAndExpand(updateUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public ResponseEntity<User> findUserById(long userId) {
		User findByUserId = dao.findByUserId(userId);
//		SimpleBeanPropertyFilter simpleBeanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("email","dateOfBirth");
//		FilterProvider filter = new SimpleFilterProvider().addFilter("userFilter", simpleBeanFilter);
//		MappingJacksonValue userFilter = new MappingJacksonValue(findByUserId);
//		userFilter.setFilters(filter);
		if (findByUserId == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(findByUserId,HttpStatus.FOUND);
	}

	@Override
	public void deleteUserById(long userId) {
		User findByUserId = dao.findByUserId(userId);
		if (findByUserId != null)
			dao.deleUserById(userId);
		else
			throw new UserNotFoundException("user not found");
	}

}

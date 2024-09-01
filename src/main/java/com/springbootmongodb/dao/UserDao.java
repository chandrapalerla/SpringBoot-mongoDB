package com.springbootmongodb.dao;

import java.util.List;

import com.springbootmongodb.model.User;

public interface UserDao {

	User saveUser(User user);

	List<User> findAllUsers();
	
	User updateUser(User user);
	
	User findByUserId(long userId);
	
	void deleUserById(long userId);
	
	
}
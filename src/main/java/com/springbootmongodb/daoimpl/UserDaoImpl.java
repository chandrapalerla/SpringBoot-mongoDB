package com.springbootmongodb.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.springbootmongodb.dao.UserDao;
import com.springbootmongodb.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public User saveUser(User user) {
		return mongoTemplate.insert(user, "UserCollection");
	}

	@Override
	public List<User> findAllUsers() {
		return mongoTemplate.findAll(User.class, "UserCollection");
	}

	@Override
	public User updateUser(User user) {
		return mongoTemplate.save(user, "UserCollection");

	}

	@Override
	public User findByUserId(long userId) {
		Query query = new Query(Criteria.where("_id").is(userId));
		return mongoTemplate.findOne(query, User.class, "UserCollection");
	}

	@Override
	public void deleUserById(long userId) {
		Query query = new Query(Criteria.where("_id").is(userId));
		mongoTemplate.remove(query, "UserCollection");
	}

}

package com.rest.poc.dao;

import java.util.List;

import com.rest.poc.model.User;

public interface UserDao {
	Long save(User user);
	User get(long id);
	List<User> list();
	void update(long id, User user);
	void delete(long id);
}

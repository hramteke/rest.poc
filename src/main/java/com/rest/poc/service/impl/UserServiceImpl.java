package com.rest.poc.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.poc.dao.UserDao;
import com.rest.poc.model.User;
import com.rest.poc.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public long save(User user) {
		return userDao.save(user);
	}

	@Override
	public User get(long id) {
		return userDao.get(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Transactional
	@Override
	public void update(long id, User user) {
		userDao.update(id, user);
	}

	@Transactional
	@Override
	public void delete(long id) {
		userDao.delete(id);
	}
}

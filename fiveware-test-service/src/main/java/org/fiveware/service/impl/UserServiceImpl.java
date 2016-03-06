package org.fiveware.service.impl;

import java.util.List;

import org.fiveware.model.dao.UserDao;
import org.fiveware.model.entity.User;
import org.fiveware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> listUsers() {
		return userDao.list();
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

}
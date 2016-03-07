package org.fiveware.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.fiveware.model.dao.UserDao;
import org.fiveware.model.entity.Interest;
import org.fiveware.model.entity.User;
import org.fiveware.service.InterestService;
import org.fiveware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private InterestService interestService;

	@Override
	public List<User> listUsers() {
		return userDao.list();
	}

	@Override
	public User findUser(Long userId) {
		return userDao.findById(userId);
	}
	
	@Override
	public void saveUser(User user) {
		Set<Interest> interests = new LinkedHashSet<>();
		for (Interest interest : user.getInterests()) {
			interests.add(interestService.findInterest(interest.getId()));
		}
		user.setInterests(interests);
		
		if (user.getId() == null) {
			userDao.save(user);
		} else {
			userDao.update(user);
		}
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.delete(new User(userId));
	}

}
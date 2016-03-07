package org.fiveware.service;

import java.util.List;

import org.fiveware.model.entity.User;

public interface UserService {

	List<User> listUsers();
	
	User findUser(Long userId);

	void saveUser(User user);

	void deleteUser(Long userId);

}
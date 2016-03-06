package org.fiveware.service;

import java.util.List;

import org.fiveware.model.entity.User;

public interface UserService {

	List<User> listUsers();
	
	void saveUser(User user);

}
package org.fiveware.web.controller;

import java.util.List;

import org.fiveware.model.entity.User;
import org.fiveware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
//	@Autowired
//	private InterestService interestService;
//	@Autowired
//	private RefDataService refDataService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listUsers() {
		return userService.listUsers();
	}
	
}
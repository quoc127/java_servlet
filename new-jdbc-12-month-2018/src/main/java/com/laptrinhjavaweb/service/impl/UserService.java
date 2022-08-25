package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO UserDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		return UserDAO.findByUserNameAndPasswordAndStatus(username, password, status);
	}

}

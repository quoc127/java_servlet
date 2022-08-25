package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstracDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user");
		sql.append("INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND passowr = ? AND status = ?");
		List<UserModel> users =  query(sql.toString(), new UserMapper(), username, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}

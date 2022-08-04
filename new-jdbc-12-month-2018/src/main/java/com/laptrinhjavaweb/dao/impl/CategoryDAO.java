package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO{

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:8000/newservlet12month2018";
			String user = "root";
			String password = "quocngu198";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
			
		}
	}
	
	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		String sql = "SELECT * FROM category";
		// mở connection
		Connection connection = getConnection();
		PreparedStatement stament = null;	
		ResultSet resultSet = null;
			if (connection != null) {
				try {
					stament = connection.prepareStatement(sql);
					resultSet = stament.executeQuery();
					while (resultSet.next()) {
						CategoryModel category = new CategoryModel();
						category.setId(resultSet.getLong("id"));
						category.setId(resultSet.getLong("code"));
						category.setId(resultSet.getLong("name"));
						results.add(category);
					}
					return results;
				} catch (SQLException e) {
					return null;
				}
				finally {
					try {
						if (connection != null) {
							connection.close();
						}
						if (stament != null) {
							stament.close();
						}
						if (resultSet != null) {
							resultSet.close();
						}
					} catch (SQLException e2) {
						return null;
					}
				}
			}
		return results;
	}

}

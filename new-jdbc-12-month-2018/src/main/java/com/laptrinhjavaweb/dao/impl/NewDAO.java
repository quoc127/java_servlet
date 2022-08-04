package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO implements INewDAO{

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
	public List<NewModel> findByCategoryId(Long categoryId) {
		List<NewModel> results = new ArrayList<>();
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		// mở connection
		Connection connection = getConnection();
		PreparedStatement stament = null;	
		ResultSet resultSet = null;
			if (connection != null) {
				try {
					stament = connection.prepareStatement(sql);
					stament.setLong(1, categoryId);
					resultSet = stament.executeQuery();
					while (resultSet.next()) {
						NewModel news = new NewModel();
						news.setId(resultSet.getLong("id"));
						news.setId(resultSet.getLong("title"));
						results.add(news);
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

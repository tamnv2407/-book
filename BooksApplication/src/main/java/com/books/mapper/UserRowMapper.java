package com.books.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.books.model.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int numRow) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setLastName(rs.getString("lastName"));
		user.setFirstName(rs.getString("firstName"));
		user.setRoleId(rs.getInt("roleKey"));

		return user;
	}

}

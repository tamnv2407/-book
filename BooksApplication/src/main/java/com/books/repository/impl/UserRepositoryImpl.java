package com.books.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.books.mapper.UserRowMapper;
import com.books.model.User;
import com.books.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value(value = "${sql.user.getUserByEmailQuery}")
	private String getUserByEmailQuery;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User getUserByEmail(String email) {
		return getJdbcTemplate().queryForObject(getUserByEmailQuery,
				new Object[] { email }, new UserRowMapper());
	}

}

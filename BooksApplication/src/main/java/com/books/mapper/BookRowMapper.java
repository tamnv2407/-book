package com.books.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.books.model.Book;

public class BookRowMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet rs, int numRow) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setAuthor(rs.getString("author"));
		book.setTitle(rs.getString("title"));
		book.setDescription(rs.getString("description"));
		book.setCreatedDate(rs.getString("createdDate"));
		book.setUpdatedDate(rs.getString("updatedDate"));

		return book;
	}
}

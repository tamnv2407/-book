package com.books.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.books.mapper.BookRowMapper;
import com.books.model.Book;
import com.books.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value(value = "${sql.book.fetchBooks}")
	private String fetchBooks;

	@Value(value = "${sql.book.createBook}")
	private String createBook;

	@Value(value = "${sql.book.getBookById}")
	private String getBookById;

	@Value(value = "${sql.book.updateBook}")
	private String updateBook;

	@Value(value = "${sql.book.deleteBook}")
	private String deleteBook;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Book> fetchBooks() {
		return getJdbcTemplate().query(fetchBooks, new BookRowMapper());
	}

	public boolean create(Book book) {
		return getJdbcTemplate().update(
				createBook,
				new Object[] { book.getTitle(), book.getAuthor(),
						book.getDescription() }) >= 1;
	}

	public Book getBookById(int bookId) {
		return getJdbcTemplate().queryForObject(getBookById,
				new Object[] { bookId }, new BookRowMapper());
	}

	public boolean update(Book book) {
		return getJdbcTemplate().update(
				updateBook,
				new Object[] { book.getTitle(), book.getAuthor(),
						book.getDescription(), book.getId() }) >= 1;
	}

	public boolean delete(int bookId) {
		return getJdbcTemplate().update(deleteBook, new Object[] { bookId }) >= 1;
	}

}

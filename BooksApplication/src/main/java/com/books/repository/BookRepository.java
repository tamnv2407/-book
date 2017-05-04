package com.books.repository;

import java.util.List;

import com.books.model.Book;

public interface BookRepository {

	List<Book> fetchBooks();

	boolean create(Book book);

	Book getBookById(int bookId);

	boolean update(Book book);

	boolean delete(int bookId);

}

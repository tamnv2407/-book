package com.books.service;

import java.util.List;

import com.books.model.Book;

public interface BookService {

	List<Book> fetchBooks();

	boolean create(Book book);

	Book getBookById(int bookId);

	boolean update(Book book);

	boolean delete(int bookId);

}

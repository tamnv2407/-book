package com.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.model.Book;
import com.books.repository.BookRepository;
import com.books.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<Book> fetchBooks() {
		return bookRepository.fetchBooks();
	}

	public boolean create(Book book) {
		return bookRepository.create(book);
	}

	public Book getBookById(int bookId) {
		return bookRepository.getBookById(bookId);
	}

	public boolean update(Book book) {		
		return bookRepository.update(book);
	}

	public boolean delete(int bookId) {		
		return bookRepository.delete(bookId);
	}
}

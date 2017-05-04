package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Book;
import com.books.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping(value="/books")
	public @ResponseBody List<Book> getBooks() {
		return bookService.fetchBooks();
	}

	@PutMapping(value = "/books")
	public @ResponseBody boolean createBook(@RequestBody Book book){
		return bookService.create(book);
	}
	
	@GetMapping(value = "/books/{id}")
	public @ResponseBody Book bookDetail(@PathVariable("id") int bookId){
		return bookService.getBookById(bookId);
	}
	
	@PostMapping(value = "/books")
	public @ResponseBody boolean update(@RequestBody Book book){
		return bookService.update(book);
	}
	
	@DeleteMapping(value = "/books/{id}")
	public @ResponseBody boolean update(@PathVariable("id") int bookId){
		return bookService.delete(bookId);
	}
}

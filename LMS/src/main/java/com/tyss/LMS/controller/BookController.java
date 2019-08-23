package com.tyss.LMS.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.LMS.dto.Book;
import com.tyss.LMS.dto.ResponseBean;
import com.tyss.LMS.services.BookServiceImpl;

@RestController
public class BookController {
	
	@Autowired
	BookServiceImpl bookservice;
	
	@PostMapping(path = "/createBookDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean createBookDetails(@RequestBody Book book) {
		return bookservice.addBookDetails(book);
	}
	@DeleteMapping(path = "/deleteBookDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean deleteBookDetails(@RequestParam int bookId, HttpServletRequest request) {

		return bookservice.deleteBook(bookId, request);

	}

	@GetMapping(path = "/getbook")
	public ResponseBean getbookByBookId(@RequestParam int bookId, HttpServletRequest request) {
		return bookservice.getbookByBookId(bookId,request);
	}


	
}

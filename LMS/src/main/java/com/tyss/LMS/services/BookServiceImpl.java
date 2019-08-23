package com.tyss.LMS.services;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.LMS.Repository.BookRepository;
import com.tyss.LMS.dto.Book;
import com.tyss.LMS.dto.ResponseBean;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public ResponseBean addBookDetails(Book book) {
		ResponseBean response = new ResponseBean();

		if (!bookRepository.existsById(book.getBookId())) {
			bookRepository.save(book);
			response.setStatusCode(201);
			response.setMessage("Sucessfully created");
			response.setDescription("Successfully Book Details created");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed to create User");
			response.setDescription("Failed to create Book data");
		}

		return response;
	}

	@Override
	public ResponseBean deleteBook(int bookId, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();
		Optional<Book> book = bookRepository.findById(bookId);
		if (request.getSession(false) != null) {

			if (book != null) {
				bookRepository.deleteById(bookId);
				response.setStatusCode(201);
				response.setMessage("Sucessfully deleted");
				response.setDescription("Successfully delete employee data");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed to delete");
				response.setDescription("Failed to delete employee data");
			}
			return response;
		} else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
		}
	}

	@Override
	public ResponseBean getbookByBookId(int bookId, HttpServletRequest request) {
		ResponseBean response = new ResponseBean();
		if (request.getSession(false) != null) {
			if (bookRepository.existsById(bookId)) {
				Book book = bookRepository.findById(bookId).get();
				response.setStatusCode(201);
				response.setMessage("Sucessfully");
				response.setDescription("Successfully found User Details by userId");
				response.setBook(Arrays.asList(book));
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Failed find User Details by userId");
			}
			return response;
		} else {
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please login first");
			return response;
		}
	}

}

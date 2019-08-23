package com.tyss.LMS.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.tyss.LMS.dto.Book;
import com.tyss.LMS.dto.ResponseBean;
import com.tyss.LMS.dto.UserDetails;
@Service
public interface BookService {
	
	
	public ResponseBean addBookDetails(Book book);
	public ResponseBean getbookByBookId(int bookId, HttpServletRequest request);
	public ResponseBean deleteBook(int bookId, HttpServletRequest request);
	
	
	
	
	
	 
	
	
}

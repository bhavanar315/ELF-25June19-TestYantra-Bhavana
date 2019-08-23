package com.tyss.LMS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.tyss.LMS.dto.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}

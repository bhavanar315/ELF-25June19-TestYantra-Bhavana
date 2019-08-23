package com.tyss.LMS.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="book_details")
public class Book implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int bookId;
	private String ISBN;
	@Column(name="book_title")
	private String bookTitle;
	@Column(name="book_authors")
	private String bookAuthors;
	private String publisher;
	@Column(name="number_of_pages")
	private long numberOfPages;
	private String category;
	@Column(name="total_number_of_copies")
	private String totalNumberOfCopies;
	private double price;
	@Column(name="book_image")
	private String bookImage;
}

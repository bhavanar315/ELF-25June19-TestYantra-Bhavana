package com.tyss.LMS.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="book_allotment")
public class BookAllotment implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_allotment_id")
	private int bookAllotmentId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails userId;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book bookId;
	
	@Column(name="issue_date")
	private Date issueDate;
	@Column(name="return_date")
	private String returnDate;
	private String status;
}

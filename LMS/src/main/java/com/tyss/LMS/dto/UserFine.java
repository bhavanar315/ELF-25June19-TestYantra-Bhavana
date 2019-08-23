package com.tyss.LMS.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="user_fine")
public class UserFine implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fine_id")
	private int fineId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails userId;
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book bookId;
	private double fine;
	private String description;
	@Column(name="payment_status")
	private String paymentStatus;
}

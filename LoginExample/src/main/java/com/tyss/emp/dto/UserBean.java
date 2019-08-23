package com.tyss.emp.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable {
	
	String userName;
	Integer password;

}

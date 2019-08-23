package com.tyss.LMS.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
//@JsonRootName("Response")
public class ResponseBean {
 
  @JsonProperty("status-code")
  private int statusCode;
  private String message;
  private String description;
  private List<UserDetails> user;
  private List<Book> book;

  
}

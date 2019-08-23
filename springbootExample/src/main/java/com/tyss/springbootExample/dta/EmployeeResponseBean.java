package com.tyss.springbootExample.dta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("Employee-Response")
public class EmployeeResponseBean {
 
  @JsonProperty("status-code")
  private int statusCode;
  private String message;
  private String description;
  private List<EmployeeInfoBean> beans;

  
}

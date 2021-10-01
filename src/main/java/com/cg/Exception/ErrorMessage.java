package com.cg.Exception;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	  private int statusCode;
	  private Date timestamp;

	  private  Map<String, String> errors ;
	  private String description;
}

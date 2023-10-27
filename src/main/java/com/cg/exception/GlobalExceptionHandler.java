package com.cg.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> resourceNotFoundException(MethodArgumentNotValidException ex, WebRequest request) {
	  Map<String, String> errors = new HashMap<>();
	  ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	  ErrorMessage message = new ErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        new Date(),
        errors,
        request.getDescription(false));
    
    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
  }
	
  
}
  
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getFieldErrors().forEach(error -> 
//
//	        errors.put(error.getField(), error.getDefaultMessage()));
//
//	     
//
//	    return errors;
//
//	}
  
//
//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
//    ErrorMessage message = new ErrorMessage(
//        HttpStatus.INTERNAL_SERVER_ERROR.value(),
//        new Date(),
//        ex.getMessage(),
//        request.getDescription(false));
//    
//    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//  }

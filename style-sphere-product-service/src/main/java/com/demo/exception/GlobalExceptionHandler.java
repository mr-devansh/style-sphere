package com.demo.exception;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String> > handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> errorMap = new HashMap<>();
		List<FieldError> fieldErrorList = e.getFieldErrors();
		fieldErrorList.stream()
		.forEach(error->{String fieldName = error.getField();
						String message = error.getDefaultMessage();
						errorMap.put(fieldName, message);});
		
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ProductTypeNotFoundException.class)
	public ResponseEntity<String> handleProtductTypeNotFoundException(ProductTypeNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
//	ProductNotFoundException
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProtductNotFoundException(ProductNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}

package com.demo.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String e) {
		super(e);
	}
}

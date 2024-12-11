package com.demo.exception;

public class ProductTypeNotFoundException extends RuntimeException {

    // Constructor accepting a custom message
    public ProductTypeNotFoundException(String message) {
        super(message);  // Pass the message to the parent RuntimeException class
    }
}

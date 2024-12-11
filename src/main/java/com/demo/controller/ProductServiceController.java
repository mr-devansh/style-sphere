package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ProductLimitConfiguration;

@RestController
@RequestMapping("api/product-service/limits")
public class ProductServiceController {
	@Autowired
	private ProductLimitConfiguration productLimitConfiguration;
	
	@GetMapping
	public ProductLimitConfiguration getLimits() {
		return productLimitConfiguration;
	}
}

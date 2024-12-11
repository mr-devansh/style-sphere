package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Product;
import com.demo.model.ProductVariant;
import com.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add a new ProductType
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct= productService.addProduct(product);
        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);  // 201 Created
    }

    @PostMapping("/{id}/variants")
    public ResponseEntity<Product> addProductVariant(@PathVariable int id, @RequestBody ProductVariant productVariant){
    	Product updatedProduct = productService.addVariant(id, productVariant);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }
    
    // Fetch a ProductType by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product= productService.findProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);  // 200 OK
    }

    // Fetch all ProductTypes
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> product = productService.findAllProduct();
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);  // 200 OK
    }

    // Update an existing ProductType
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct= productService.updateProduct(id, product);
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);  // 200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id){
        Product deletedProduct= productService.deleteProduct(id);
        return new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
    }
}

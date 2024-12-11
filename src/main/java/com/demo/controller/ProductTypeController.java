package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.ProductType;
import com.demo.service.ProductTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/producttype")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    // Add a new ProductType
    @PostMapping("/add")
    public ResponseEntity<ProductType> addProductType(@RequestBody ProductType productType) {
        ProductType createdProductType = productTypeService.addProductType(productType);
        return new ResponseEntity<ProductType>(createdProductType, HttpStatus.CREATED);  // 201 Created
    }

    // Fetch a ProductType by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable int id) {
        ProductType productType = productTypeService.findProductTypeById(id);
        return new ResponseEntity<ProductType>(productType, HttpStatus.OK);  // 200 OK
    }

    // Fetch all ProductTypes
    @GetMapping("/all")
    public ResponseEntity<List<ProductType>> getAllProductTypes() {
        List<ProductType> productTypes = productTypeService.findAllProductTypes();
        return new ResponseEntity<List<ProductType>>(productTypes, HttpStatus.OK);  // 200 OK
    }

    // Update an existing ProductType
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductType> updateProductType(@PathVariable int id, @RequestBody ProductType productType) {
        ProductType updatedProductType = productTypeService.updateProductType(id, productType);
        return new ResponseEntity<ProductType>(updatedProductType, HttpStatus.OK);  // 200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductType> deleteProductType(@PathVariable int id){
        ProductType deletedProductType = productTypeService.deleteProductType(id);
        return new ResponseEntity<ProductType>(deletedProductType, HttpStatus.OK);
    }
}

package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.ProductTypeNotFoundException;
import com.demo.model.ProductType;
import com.demo.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    // Default constructor (optional)
    public ProductTypeService() {
        super();
    }

    // Add a new ProductType
    public ProductType addProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    // Find a ProductType by ID
    public ProductType findProductTypeById(int id) {
        return productTypeRepository.findById(id)
                .orElseThrow(() -> new ProductTypeNotFoundException("ProductType with ID " + id + " not found"));
    }

    // Update an existing ProductType
    public ProductType updateProductType(int id, ProductType productType) {
        ProductType existingProductType = findProductTypeById(id);
        existingProductType.setName(productType.getName());
        existingProductType.setDescription(productType.getDescription());
        existingProductType.setAttributes(productType.getAttributes());
        return productTypeRepository.save(existingProductType);
    }

    // Fetch all ProductTypes
    public List<ProductType> findAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public ProductType deleteProductType(int id) {
        // Check if the ProductType exists first
        ProductType existingProductType = findProductTypeById(id);
        // Delete the ProductType if it exists
        productTypeRepository.delete(existingProductType);
        return existingProductType;
    }
    // Additional custom methods can be added based on your business logic
}

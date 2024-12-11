package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.ProductNotFoundException;
import com.demo.exception.ProductTypeNotFoundException;
import com.demo.model.Product;
import com.demo.model.ProductType;
import com.demo.model.ProductVariant;
import com.demo.repository.ProductRepository;
import com.demo.repository.ProductTypeRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Default constructor (optional)
    public ProductService() {
        super();
    }

    // Add a new ProductType
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product addVariant(int id, ProductVariant productVariant) {
    	Product foundProduct = findProductById(id);
    	List<ProductVariant> listy = foundProduct.getProductVariants();
    	listy.add(productVariant);
    	foundProduct.setProductVariants(listy);
    	return productRepository.save(foundProduct);
    }
    // Find a ProductType by ID
    public Product findProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    // Update an existing ProductType
    public Product updateProduct(int id, Product product) {
    	Product foundProduct = findProductById(id);
    	foundProduct.setName(product.getName());
    	foundProduct.setPrice(product.getPrice());
    	foundProduct.setDescription(product.getDescription());
    	foundProduct.setProductType(product.getProductType());
    	foundProduct.setProductVariants(product.getProductVariants());
    	foundProduct.setCategory(product.getCategory());

        return productRepository.save(foundProduct);
    }

    // Fetch all ProductTypes
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product deleteProduct(int id) {
        // Check if the ProductType exists first
    	Product existingProduct = findProductById(id);
        // Delete the ProductType if it exists
        productRepository.delete(existingProduct);
        return null;
    }
    // Additional custom methods can be added based on your business logic
}

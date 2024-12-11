package com.demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.AttributeDefinition;
import com.demo.model.AttributeType;
import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.model.ProductType;
import com.demo.model.ProductVariant;
import com.demo.repository.CategoryRepository;
import com.demo.repository.ProductRepository;

import lombok.Data;
@Data
@SpringBootApplication
public class ProductServiceApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(ProductServiceApplication.class, args);
//		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
//		ProductRepository productRepository = context.getBean(ProductRepository.class);
//		
//		Category books = new Category(1, "Books", null, "book category");
//		Category science = new Category(2, "science", books, "science category");
//		Category fictional = new Category(3, "fictional", books, "fictional category");
//		Category horror = new Category(4, "horror", books, "horror category");
//
//		Category nun = new Category(5, "nun", horror, "nun category");
//		Category orphan = new Category(6, "orphan", horror, "orphan category");
//
//		List<AttributeDefinition> bookAttributes = new ArrayList<>();
//		bookAttributes.add(new AttributeDefinition(1, "Mode", AttributeType.ENUM, Arrays.asList("Online","Offline")));
//		bookAttributes.add(new AttributeDefinition(2, "Genre", AttributeType.TEXT, Arrays.asList("Fiction", "Non-fiction", "Mystery", "Fantasy", "Biography")));
//		
//		ProductType bookProductType = new ProductType(1, "Books", "books product type", bookAttributes);
//		
//		Map<String, String> hardyBoisAttributes = new HashMap<>();
//		hardyBoisAttributes.put(bookProductType.getAttributes().get(0).getName(), bookProductType.getAttributes().get(0).getAllowedValues().get(1));
//		hardyBoisAttributes.put(bookProductType.getAttributes().get(1).getName(), bookProductType.getAttributes().get(1).getAllowedValues().get(2));
//		
//		categoryRepository.save(books);
//		categoryRepository.save(science);
//		categoryRepository.save(fictional);
//		categoryRepository.save(horror);
//		categoryRepository.save(nun);
//		categoryRepository.save(orphan);
//		
//		Product bookProduct = new Product(1, "Book", 2000, "books product", bookProductType, books, null);
////		productRepository.save(bookProduct);		
//		ProductVariant HardyBois = new ProductVariant(1, hardyBoisAttributes, 100, 100, bookProduct);
//		bookProduct.setProductVariants(Arrays.asList(HardyBois));
//		productRepository.save(bookProduct);		
//		
	}

}

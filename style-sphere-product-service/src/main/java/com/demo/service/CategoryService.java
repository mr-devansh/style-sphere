package com.demo.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.CategoryNotFoundException;
import com.demo.model.Category;
import com.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryService() {
		super();
		// TODO Auto-generated constructor stub
	}
	//
//	public Category addCategory(Category category) {
//		Category parent = category.getParentCategory();
//		category.setParentCategory(parent);
//		return categoryRepository.save(category);
//	}
	
	public Category addCategory(Category category) {
        // Check if a parent category is provided, and if it exists
        if (category.getParentCategory() != null && category.getParentCategory().getId() != 0) {
            Category parent = categoryRepository.findById(category.getParentCategory().getId())
                    .orElseThrow(() -> new CategoryNotFoundException("Parent Category not found"));
            category.setParentCategory(parent); // Set the valid parent category
        } else {
            category.setParentCategory(null); // If no valid parent category is provided, set it to null
        }

        // Save the new category
        return categoryRepository.save(category);
    }
	
	public Category findCategoryByID(int id){
		return categoryRepository.findById(id)
				.orElseThrow(()-> new CategoryNotFoundException("Employee with ID "+id+", not Found"));
	}
	
	public Category updateCategory(int id, Category category) {
		Category found = findCategoryByID(id);
		found = category;
		found.setId(id);
		return categoryRepository.save(found);
	}
	
	public List<Category> findAllCategory(){
		return categoryRepository.findAll();
	}
	
	public Category findParentCategory(int id){
		Category found = findCategoryByID(id);
		return categoryRepository.fetchParent(found.getId());
	}
	
	public List<Category> findAllSubCategories(int id){
		Category found = findCategoryByID(id);
		return categoryRepository.fetchAllSubCategories(found.getId());
	}
	
}

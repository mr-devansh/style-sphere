package com.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.service.CategoryService;


@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("api/category/add")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category cat = categoryService.addCategory(category);
		return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
	}
	
	@PutMapping("api/category/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
		Category cat = categoryService.updateCategory(id, category);
		return new ResponseEntity<Category>(cat,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("api/category/get/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id){
		Category cat = categoryService.findCategoryByID(id);
		return new ResponseEntity<Category>(cat,HttpStatus.OK);
	}
	
	@GetMapping("api/category/get")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> cat = categoryService.findAllCategory();
		return new ResponseEntity<List<Category>>(cat,HttpStatus.OK);
	}
	
	@GetMapping("api/category/getsubs/{id}")
	public ResponseEntity<List<Category>> getSubCategories(@PathVariable int id){
		List<Category> cat = categoryService.findAllSubCategories(id);
		return new ResponseEntity<List<Category>>(cat,HttpStatus.OK);
	}
	
	@GetMapping("api/category/getparent/{id}")
	public ResponseEntity<Category> getParentCategory(@PathVariable int id){
		Category cat = categoryService.findCategoryByID(id);
		Category catparent = categoryService.findParentCategory(cat.getId());
		return new ResponseEntity<Category>(catparent, HttpStatus.OK);
	}
}

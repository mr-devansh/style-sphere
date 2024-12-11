package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("SELECT e FROM Category e WHERE e.parentCategory.id = :parent")
	public List<Category> fetchAllSubCategories(int parent);
	
	@Query("SELECT e.parentCategory FROM Category e WHERE e.id = :id")
	public Category fetchParent(int id);
	
}
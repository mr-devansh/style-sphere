package com.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
@Entity
public class Category {
	@Id
	private int id;
	
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Category parentCategory;
	
	private String description;
	
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Category> subCategories;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String name, Category parentCategory, String description) {
		super();
		this.id = id;
		this.name = name;
		this.parentCategory = parentCategory;
		this.description = description;
	}
	@Override
	public String toString() {
		return "\nCategory [id=" + id + ", name=" + name + ", \tparentCategory=" + parentCategory + ", description="
				+ description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Category> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
}

package com.demo.model;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class ProductType {
	@Id
	private int id;
	
	private String name;
	
	private String description;

	@OneToMany(cascade=CascadeType.ALL)
	private List<AttributeDefinition> attributes = new ArrayList<>();
	
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", description=" + description + ", attributes="
				+ attributes + "]";
	}

	public ProductType(int id, String name, String description, List<AttributeDefinition> attributes) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.attributes = attributes;
	}

	public ProductType() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AttributeDefinition> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributeDefinition> attributes) {
		this.attributes = attributes;
	}
	
	
}


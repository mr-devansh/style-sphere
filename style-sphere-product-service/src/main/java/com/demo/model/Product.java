package com.demo.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private long price;
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private ProductType productType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<ProductVariant> productVariants = new ArrayList<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addProductVariant(ProductVariant variant) {
        productVariants.add(variant);
        variant.setProduct(this); // Set the owning side reference
    }

    public void removeProductVariant(ProductVariant variant) {
        productVariants.remove(variant);
        variant.setProduct(null); // Clear the owning side reference

    }
	public Product(int id, String name, long price, String description, ProductType productType, Category category, List<ProductVariant> productVariants) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.productType = productType;
		this.category = category;
		this.productVariants = productVariants;
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductVariant> getProductVariants() {
		return productVariants;
	}

	public void setProductVariants(List<ProductVariant> productVariants) {
		this.productVariants = productVariants;
	}
	
	
	
}

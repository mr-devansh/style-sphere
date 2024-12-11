package com.demo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ProductVariant {
	@Id
	private int id;
	
	@ElementCollection
	private Map<String,String> variantAttributes;
	
	private int stock;
	
	private long additionalPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id_ref")
	@JsonBackReference
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getVariantAttributes() {
		return variantAttributes;
	}

	public void setVariantAttributes(Map<String, String> variantAttributes) {
		this.variantAttributes = variantAttributes;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public long getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(long additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductVariant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVariant(int id, Map<String, String> variantAttributes, int stock, long additionalPrice,
			Product product) {
		super();
		this.id = id;
		this.variantAttributes = variantAttributes;
		this.stock = stock;
		this.additionalPrice = additionalPrice;
		this.product = product;
	}
	
	
}

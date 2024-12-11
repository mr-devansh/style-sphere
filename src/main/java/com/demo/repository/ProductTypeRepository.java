package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

}

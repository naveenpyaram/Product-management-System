package com.ProductManagementSystem.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ProductManagementSystem.entity.Products;

public interface Productservice {
	public List<Products> getallproducts();
	public Products saveproduct(Products product);
	public Products getById(int id);
	public void deletebyid(int id);
	public Page<Products> findall(int page, int totalpage);
	
}

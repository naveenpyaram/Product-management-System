package com.ProductManagementSystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ProductManagementSystem.entity.Products;
import com.ProductManagementSystem.repository.Productrepository;
import com.ProductManagementSystem.service.Productservice;


@Service
public class Productserviceimpl  implements Productservice{

	@Autowired
	private Productrepository productrepository;
	@Override
	public List<Products> getallproducts() {
		List<Products> list = productrepository.findAll();
		return list;
	}
	@Override
	public Products saveproduct(Products product) {
	
		return productrepository.save(product);
	}

	@Override
	public Products getById(int id) {
		// TODO Auto-generated method stub
		return productrepository.findById(id).get();
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		productrepository.deleteById(id);
		
	}
	@Override
	public Page<Products> findall(int page, int totalpage) {
		Pageable p = PageRequest.of(page, totalpage);
		return productrepository.findAll(p);
	}
	


}

package com.ProductManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductManagementSystem.entity.Products;

@Repository
public interface Productrepository  extends JpaRepository<Products, Integer>{

}

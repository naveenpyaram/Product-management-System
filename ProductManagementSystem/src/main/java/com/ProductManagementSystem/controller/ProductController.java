package com.ProductManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ProductManagementSystem.entity.Products;
import com.ProductManagementSystem.service.Productservice;


@Controller
public class ProductController {
	 @Autowired
	private Productservice service;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("products")
	public String getallproducts(Model model) {
		model.addAttribute("products", service.getallproducts());
		
		return findpaginated(0, model);
	}
	@GetMapping("/products/new")
	public String createproduct(Model model) {
		Products std = new Products();
		model.addAttribute("products", std);
		return "create-product";
	}
	@PostMapping("/products")
	public String saveproduct(@ModelAttribute("products") Products product) {
		service.saveproduct(product);
		return "redirect:/products";
	}
	@GetMapping("/products/edit/{id}")
	public String editproductform(@PathVariable int id, Model model) {
		model.addAttribute("products", service.getById(id));
		return "update-product";
	}
	@PostMapping("/products/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("products") Products product,MultipartFile file) {
		Products existingproduct = service.getById(id);
		 existingproduct.setName(product.getName());
		 existingproduct.setBrand(product.getBrand());
		 existingproduct.setCategory(product.getCategory());
		 existingproduct.setPrice(product.getPrice());
		 existingproduct.setImagename(product.getImagename());
		 service.saveproduct(existingproduct);
		 return "redirect:/products";
	}
	@GetMapping("/products/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deletebyid(id);
		return "redirect:/products";
	}
	@GetMapping("/products/{pageno}")
	public String findpaginated(@PathVariable int pageno,Model model) {
		Page<Products> productslist =  service.findall(pageno, 2);
		model.addAttribute("products", productslist);
		model.addAttribute("page",pageno);
		model.addAttribute("totalpage",productslist.getTotalPages());
		model.addAttribute("totalitem", productslist.getTotalElements());
		return "products";
	}
	
}

package com.example.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Product;
import com.example.productservice.repo.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/all")
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@PostMapping("/save")
	public Product save(@RequestBody Product p) {
		return productRepository.save(p);
	}
}

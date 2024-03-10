package com.se.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.product.entity.Product;
import com.se.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void save(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

}

package com.se.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.product.entity.Product;
import com.se.product.repository.ProductJPARepository;
import com.se.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductJPARepository jpaRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public void save(Product product) {
		Product p =  jpaRepository.save(product);
		System.out.println(p.toString());
		productRepository.save(p);
	}

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductById(int id) {
		return productRepository.getProductById(id);
	}
}

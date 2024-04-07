package com.example.Product.service;

import org.springframework.stereotype.Service;

import com.example.Product.entity.Product;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class ProductService {

	@RateLimiter(name = "myRateLimiter")
	public Product getProduct() {
		return new Product(1, "Ti vi");
	}
}

package com.se.product.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.se.product.entity.Product;

@Repository
public class ProductRepository {

	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;

	public ProductRepository(RedisTemplate redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	public void save(Product product) {
		hashOperations.put("PRODUCT", product.getId(), product);
	}

	public List<Product> getAllProducts() {
		return hashOperations.values("PRODUCT");
	}
	
	public Product getProductById(int id) {
		return (Product) hashOperations.get("PRODUCT", id);
	}
}

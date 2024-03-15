package com.se.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.product.entity.Product;

public interface ProductJPARepository extends JpaRepository<Product, Integer>{

}

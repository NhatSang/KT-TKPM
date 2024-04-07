package com.example.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.service.RetryService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private RetryService retryService;
	
	@GetMapping("/product")
	public String getproduct() {
		return retryService.getProducts();
	}
}

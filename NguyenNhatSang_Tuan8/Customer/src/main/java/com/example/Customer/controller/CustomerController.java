package com.example.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.service.RetryService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private RetryService retryService;
	
	@GetMapping("/product")
	@Retry(name = "retryApi")
	@RateLimiter(name = "myRatelimiter")
	public String getproduct() {
		return retryService.getProducts();
	}
}

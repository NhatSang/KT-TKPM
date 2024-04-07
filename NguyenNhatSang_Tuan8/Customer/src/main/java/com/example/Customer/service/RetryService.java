package com.example.Customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.Retry;

@Service
public class RetryService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Retry retryConfig;

	public String getProducts() {
		try {
			return retryConfig.executeSupplier(() -> {
				return restTemplate.getForObject("http://localhost:8080/products/", String.class);
			});
		} catch (Exception e) {
			// TODO: handle exception
			return "Error: " + e;
		}

	}

}

package com.example.Customer.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;

@Configuration
public class Resilient4jConfig {

	@Bean
	public Retry retryConfig() {
		RetryConfig config = RetryConfig.custom().maxAttempts(5).waitDuration(Duration.ofSeconds(5)).build();
		return Retry.of("retryConfig", config);
	}
}

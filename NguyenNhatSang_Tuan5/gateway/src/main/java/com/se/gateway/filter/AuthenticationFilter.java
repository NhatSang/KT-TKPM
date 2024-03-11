package com.se.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.se.gateway.Validator.RouteValidator;
import com.se.gateway.util.JWTUtil;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator validator;

	@Autowired
	private JWTUtil jwtUtil;

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange, chain) -> {
			if (validator.isSecured.test(exchange.getRequest())) {
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("not found authorization header");
				}
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				try {
					jwtUtil.validateToken(authHeader);
				} catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException("invalid access");
				}
			}
			return chain.filter(exchange);
		});
	}

	public static class Config {

	}
}

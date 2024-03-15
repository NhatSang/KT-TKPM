package com.se.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.user.dto.Account;
import com.se.user.entity.User;
import com.se.user.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private AuthenticationManager manager;

	@PostMapping("/register")
	public String saveUser(@RequestBody User user) {
		return service.save(user);
	}

	@PostMapping("/login")
	public String getToken(@RequestBody Account account) {
		Authentication authentication = manager
				.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
		if (authentication.isAuthenticated()) {
			return service.generateToken(account.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}
	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		service.validateToken(token);
		return "Token is valid";
	}
}

package com.se.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.order.dto.OrderDTO;
import com.se.order.entity.Order;
import com.se.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public String save(@RequestBody Order order) {
		return orderService.save(order);
	}

	@GetMapping("/all")
	public List<OrderDTO> getAll() {
		return orderService.getAll();
	}
}

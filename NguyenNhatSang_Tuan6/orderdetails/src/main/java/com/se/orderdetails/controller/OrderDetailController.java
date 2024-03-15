package com.se.orderdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.orderdetails.dto.OrderDetailDTO;
import com.se.orderdetails.entity.OrderDetail;
import com.se.orderdetails.service.OrderDetailService;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {

	@Autowired
	private OrderDetailService detailService;
	
	@GetMapping("/all")
	public List<OrderDetailDTO> getAll(){
		return detailService.getAll();
	}
	
	@PostMapping("/save")
	public String save(@RequestBody OrderDetail orderDetail) {
		detailService.save(orderDetail);
		return "true";
		
	}
	
	@GetMapping("/{id}")
	public OrderDetailDTO getById(@PathVariable int id) {
		return detailService.getById(id);
	}

}

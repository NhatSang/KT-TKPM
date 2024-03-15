package com.se.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.order.dto.OrderDTO;
import com.se.order.dto.OrderDetail;
import com.se.order.dto.User;
import com.se.order.entity.Order;
import com.se.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<OrderDTO> getAll() {
		List<OrderDTO> list = new ArrayList<OrderDTO>();

		orderRepository.findAll().forEach((o) -> {
			List<OrderDetail> ods = new ArrayList<OrderDetail>();
			User user = restTemplate.getForObject("http://localhost:8082/auth/" + o.getUserId(), User.class);
			o.getOrderDetails().forEach((odid) -> {
				OrderDetail od = restTemplate.getForObject("http://localhost:8084/orderdetails/" + odid, OrderDetail.class);
				ods.add(od);
			});
			OrderDTO orderDTO = new OrderDTO(o.getId(), user, ods);
			list.add(orderDTO);
		});

		return list;
	}

	public String save(Order order) {
		orderRepository.save(order);
		return "true";
	}
}

package com.se.orderdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.orderdetails.dto.OrderDetailDTO;
import com.se.orderdetails.dto.ProductDTO;
import com.se.orderdetails.entity.OrderDetail;
import com.se.orderdetails.repository.OrderDetailRepository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository detailRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<OrderDetailDTO> getAll() {
		List<OrderDetailDTO> list = new ArrayList<OrderDetailDTO>();
		detailRepository.findAll().forEach((od) -> {
			ProductDTO p = restTemplate.getForObject("http://localhost:8081/products/" + od.getProductId(),
					ProductDTO.class);
			System.out.println(p);
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO(od.getId(), p, od.getQuantity());
			list.add(orderDetailDTO);
		});
		;

		return list;
	}

	public OrderDetailDTO getById(int id) {
		OrderDetail od = detailRepository.findById(id);
		ProductDTO p = restTemplate.getForObject("http://localhost:8081/products/" + od.getProductId(),
				ProductDTO.class);

		return new OrderDetailDTO(od.getId(), p, od.getQuantity());
	}

	public void save(OrderDetail orderDetail) {
		detailRepository.save(orderDetail);
	}
}

package com.se.order.dto;

import java.util.List;

public class OrderDTO {
	private int id;
	private User user;
	private List<OrderDetail> orderDetails;

	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int id, User user, List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.user = user;
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", user=" + user + ", orderDetails=" + orderDetails + "]";
	}

}

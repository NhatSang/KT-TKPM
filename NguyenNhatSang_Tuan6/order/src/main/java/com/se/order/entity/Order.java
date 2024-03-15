package com.se.order.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private List<Integer> orderDetails;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int userId, List<Integer> orderDetails) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Integer> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Integer> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderDetails=" + orderDetails + "]";
	}

}

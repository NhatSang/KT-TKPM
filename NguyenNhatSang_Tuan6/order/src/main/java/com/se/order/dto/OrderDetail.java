package com.se.order.dto;

public class OrderDetail {
	private int id;
	private Product product;
	private int quantiy;

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int id, Product product, int quantiy) {
		super();
		this.id = id;
		this.product = product;
		this.quantiy = quantiy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", product=" + product + ", quantiy=" + quantiy + "]";
	}

}

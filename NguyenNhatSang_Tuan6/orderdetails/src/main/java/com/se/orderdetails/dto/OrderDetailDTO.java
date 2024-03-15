package com.se.orderdetails.dto;

public class OrderDetailDTO {
	private int id;
	private ProductDTO product;
	private int quantiy;

	public OrderDetailDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetailDTO(int id, ProductDTO product, int quantiy) {
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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
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
		return "OrderDetailDTO [id=" + id + ", product=" + product + ", quantiy=" + quantiy + "]";
	}

}

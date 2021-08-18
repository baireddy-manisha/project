package com.app.model;

public class Order {
	private int order_id;
	private String order_name;
	private int quantity;
	
	public Order () {
		// TODO Auto-generated constructor stub
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "order [order_id=" + order_id + ", order_name=" + order_name + ", quantity=" + quantity + "]";
	}
	

}


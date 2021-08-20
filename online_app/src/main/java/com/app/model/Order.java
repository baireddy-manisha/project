package com.app.model;

public class Order {
	private int order_id;
	private String product_name;
	private int id;
	private int product_id;
	private double price;
	private String orderShipped;
	private String orderReceived;
	
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrderShipped() {
		return orderShipped;
	}

	public void setOrderShipped(String orderShipped) {
		this.orderShipped = orderShipped;
	}

	public String getOrderReceived() {
		return orderReceived;
	}

	public void setOrderReceived(String orderReceived) {
		this.orderReceived = orderReceived;
	}

	public Order () {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_name() {
		return product_name;
	}
	public void setOrder_name(String order_name) {
		this.product_name = order_name;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", product_name=" + product_name +  ", id="
				+ id + ", product_id=" + product_id + ", price=" + price + ", orderShipped=" + orderShipped
				+ ", orderReceived=" + orderReceived + "]";
	}
	

}


package com.app.model;

public class Product {
	private int product_id;
	private String product_name;
	private double price;
	private float quantity;
	private float rating;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
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
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + ", rating=" + rating + "]";
	}
	
}
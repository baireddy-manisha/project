package com.app.model;

public class Cart {
       private int id;
       private int  product_id;
       
       public Cart() {
   		super();
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
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product_id=" + product_id + "]";
	}
	
 
}

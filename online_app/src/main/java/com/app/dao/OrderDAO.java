package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.model.Cart;
import com.app.model.Order;

public interface OrderDAO {
	public double placingOrder(List<Product> product,int id) throws  BusinessException;
	public List<Order> displayOrder() throws BusinessException;
	public List<Order> getOrderById(int id) throws BusinessException;
	

}

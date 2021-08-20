package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.model.Cart;


public interface CartDAO {
	public int addcart(int id,int product_id) throws BusinessException;
	public List<Product> getAllItemsIncart(int id) throws BusinessException;
	
	}

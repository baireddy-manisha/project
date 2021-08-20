package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductSearchDAO {
public List<Product> getAllProducts() throws BusinessException;	
public Product getProductByProduct_id(int product_id) throws BusinessException;
public List<Product> getProductByProduct_name(String product_name) throws BusinessException;
public List<Product> getProductByPrice(double price) throws BusinessException;
public List<Product> getProductByQuantity(float quantity) throws BusinessException;
public List<Product> getProductByRating(float rating) throws BusinessException;
public List<Product> getProductByCategory(String category) throws BusinessException;

}

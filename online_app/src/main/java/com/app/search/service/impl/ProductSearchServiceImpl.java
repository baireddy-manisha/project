package com.app.search.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.dao.dbutil.MySqlDbConnection;

import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.search.service.ProductSearchService;


public class ProductSearchServiceImpl implements ProductSearchService{
	private ProductSearchDAO productSearchDAO=new ProductSearchDAOImpl();
	@Override
	public Product getProductByProduct_id(int product_id) throws BusinessException {
		Product product=null;
		if(product_id<1 ||product_id>100) {
			throw new BusinessException("Invalid Product Id "+product_id);
		}else {
			//code here to DAO
			product=productSearchDAO.getProductByProduct_id(product_id);
			
		}
		return product;
		
	}

	@Override
	public List<Product> getProductByProduct_name(String product_name) throws BusinessException {
			List<Product> productList=null;
			if(product_name.matches("[a-zA-Z]{2,10}")) {
				//code here to DAO
				productList=productSearchDAO.getProductByProduct_name(product_name);
			}else {
				throw new BusinessException("Invalid  product name : "+product_name);
			}
			return productList;
		}

	

	@Override
	public List<Product> getProductByPrice(double price) throws BusinessException {
		List<Product> productList=null;
	      if(price<=0) {
				throw new BusinessException("Invalid Price "+price);
			}else {
				//code here to DAO
				productList=productSearchDAO.getProductByPrice(price);
				
			}
			return productList;
	}

	@Override
	public List<Product> getProductByQuantity(float quantity) throws BusinessException {
		List<Product> productList=null;
	      if(quantity<=0) {
				throw new BusinessException("Invalid quantity "+quantity);
			}else {
				//code here to DAO
				productList=productSearchDAO.getProductByQuantity(quantity);
				
			}
			return productList;
	}

	@Override
	public List<Product> getProductByRating(float rating) throws BusinessException {
		List<Product> productList=null;
	      if(rating<0 || rating>5) {
				throw new BusinessException("Invalid Rating "+rating);
			}else {
				//code here to DAO
				productList=productSearchDAO.getProductByRating(rating);
				
			}
			return productList;
	}
	@Override
	public List<Product> getProductByCategory(String category) throws BusinessException {
		List<Product> productList=null;
	      if(category.matches("[a-zA-Z]{2,10}")) {
				//code here to DAO
				productList=productSearchDAO.getProductByCategory(category);
			}else {
				throw new BusinessException("Invalid  category : "+category);
			}
			return productList;
		}
}
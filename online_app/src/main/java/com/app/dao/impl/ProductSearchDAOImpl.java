package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductSearchDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;
public class ProductSearchDAOImpl implements ProductSearchDAO {
private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);
	@Override
	public Product getProductByProduct_id(int product_id) throws BusinessException {
		Product product=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,product_name,price,quantity,rating,category from product p where p.product_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, product_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setProduct_id(product_id);
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				
				
			}else {
				throw new BusinessException("Entered product_id "+product_id+" doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return product;
	}


	@Override
	public List<Product> getProductByProduct_name(String product_name) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,product_name,price,quantity,rating,category from product p where p.product_name=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,product_name);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product=new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Players for team "+product_name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}
	
	@Override
	public List<Product> getProductByPrice(double price) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,product_name,price,quantity,rating,category from product p where p.price=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1,price);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product=new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Players for team "+price);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
		
	}

	@Override
	public List<Product> getProductByQuantity(float quantity) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,product_name,price,quantity,rating,category from product p where p.quantity=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setFloat(1,quantity);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product=new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Players for team "+quantity);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}
	
		

	@Override
	public List<Product> getProductByRating(float rating) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,product_name,price,quantity,rating,category from product p where p.rating=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setFloat(1,rating);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product=new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Players for team "+rating);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}
	
	
	@Override
	public List<Product> getProductByCategory(String category) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,product_name,price,quantity,rating,category from product p where p.category=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,category);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product=new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Players for team "+category);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}
	
		

}

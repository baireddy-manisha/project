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
import com.app.dao.EmployeeDAO;
public class EmployeeDAOImpl implements EmployeeDAO{
private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);

@Override
public int Addproduct(Product product) throws BusinessException {
	int c=0;
	try(Connection connection=MySqlDbConnection.getConnection()){
		String sql="insert into product(product_id,product_name,price,quantity,rating,category) values(?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, product.getProduct_id());
		preparedStatement.setString(2, product.getProduct_name());
		preparedStatement.setDouble(3, product.getPrice());
		preparedStatement.setFloat(4, product.getQuantity());
		preparedStatement.setFloat(5, product.getRating());
		preparedStatement.setString(6, product.getCategory());	
		c=preparedStatement.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println(e);//this will be replaced by logger
		throw new BusinessException("Internal error occured, please contact support");
	}
	return c;
}


@Override
public List<Product> getAllProducts() throws BusinessException {
	List<Product> productList=new ArrayList<>();
	try(Connection connection=MySqlDbConnection.getConnection()){
		String sql="select product_id,product_name,price,quantity,rating,category from product";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			Product product=new Product();
			product.setProduct_id(resultSet.getInt("product_id"));
			product.setProduct_name(resultSet.getString("product_name"));
			product.setPrice(resultSet.getDouble("price"));
			product.setQuantity(resultSet.getFloat("quantity"));
			product.setRating(resultSet.getFloat("rating"));
			product.setCategory(resultSet.getString("category"));
			productList.add(product);
		}
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println(e);//this will be replaced by logger
		throw new BusinessException("Internal error occured, please contact support");
	}
	
	return productList;
	
}

}

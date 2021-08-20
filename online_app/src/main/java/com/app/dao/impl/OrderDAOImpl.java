package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.app.dao.OrderDAO;
import com.app.model.Order;
import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.ProductSearchDAOImpl;

public class OrderDAOImpl implements OrderDAO {
private static Logger log = Logger.getLogger(OrderDAOImpl.class);
	@Override
	public double placingOrder(List<Product> product,int id) throws BusinessException {
		double totalcost=0;
		int a=0;
		String orderShipped="no";
		String orderReceived="no";
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into manisha.order(id,product_id,product_name,price,orderShipped,orderReceived) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<product.size();i++) {
			preparedStatement.setInt(1,id);
			preparedStatement.setInt(2,product.get(i).getProduct_id());
			preparedStatement.setString(3,product.get(i).getProduct_name());
			preparedStatement.setDouble(4,product.get(i).getPrice());
			preparedStatement.setString(5,orderShipped);
			preparedStatement.setString(6,orderReceived);
			totalcost=totalcost+(product.get(i).getPrice());
			int c=preparedStatement.executeUpdate();
			a=a+c;
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		if(a==product.size()) {
			log.info("order has placed Successfully!!!");
		}
		else {
			throw new BusinessException("failed,try again");
		}
			
		return totalcost;
	}
	
	@Override
	public List<Order> displayOrder() throws BusinessException{
		List<Order> orderList = new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select order_id,id,product_id,product_name,price,orderShipped,orderReceived from manisha.order";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order product=new Order();
				product.setOrder_id(resultSet.getInt("order_id"));
				product.setId(resultSet.getInt("id"));
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setOrderShipped(resultSet.getString("ordershipped"));
				product.setOrderReceived(resultSet.getString("orderReceived"));
				orderList.add(product);
			}
		}catch (ClassNotFoundException | SQLException e) {
				log.error(e);
				throw new BusinessException("Internal error occured contact sysadmin");
			}
		
		return orderList;
	}
	
	@Override
	public List<Order> getOrderById(int id) throws BusinessException{
		List<Order> orderList = new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select order_id,id,product_id,product_name,price,orderShipped,orderReceived from manisha.order where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order product=new Order();
				product.setOrder_id(resultSet.getInt("order_id"));
				product.setId(resultSet.getInt("id"));
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setOrderShipped(resultSet.getString("ordershipped"));
				product.setOrderReceived(resultSet.getString("orderReceived"));
				orderList.add(product);
			}
		}catch (ClassNotFoundException | SQLException e) {
				log.error(e);
				throw new BusinessException("Internal error occured contact sysadmin");
			}
		
		return orderList;
	}
	

}

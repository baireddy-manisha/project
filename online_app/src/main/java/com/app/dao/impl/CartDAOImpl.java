package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

   public class CartDAOImpl implements CartDAO{
	private static Logger log = Logger.getLogger(CartDAOImpl.class);
	@Override
	public int addcart(int id ,int product_id) throws BusinessException {
		Cart cart=null;
		Product product=new Product();
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
				String sql="insert into cart(id,product_id) values(?,?)";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1,id);
				preparedStatement.setInt(2,product_id);
				c=preparedStatement.executeUpdate();	
				if(c==1) {
					log.info("Added to the cart");
				}
					else {
						log.info("Not added to cart");
					}
				
			} catch (ClassNotFoundException | SQLException e) {
				log.error(e);
				throw new BusinessException("Internal error occured contact sysadmin");
			}
			return c;
		}
	@Override
	public List<Product> getAllItemsIncart(int id) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.product_id,cart.id cart_id,product_name,price,quantity,rating,category from product p  join cart on cart.product_id=p.product_id and cart.id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product.setProduct_id(resultSet.getInt("Product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getFloat("quantity"));
				product.setRating(resultSet.getFloat("rating"));
				product.setCategory(resultSet.getString("category"));
				Cart cart=new Cart();
				cart.setId(resultSet.getInt("cart_id"));
			    cart.setProduct_id(resultSet.getInt("product_id"));
				productList.add(product);

			}
			if(productList.size()==0) {
			throw new BusinessException("No customer for id "+id);
			}
			else {
				log.info("Displaying the Products");
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}
		
   }

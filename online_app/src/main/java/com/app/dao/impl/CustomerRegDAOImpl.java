package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.CustomerRegDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerRegDAOImpl implements CustomerRegDAO{

	@Override
	public int createAccount(Customer customer) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into customer(id,firstname,lastname,email,password) values(?,?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getFirstname());
			preparedStatement.setString(3, customer.getLastname());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPassword());
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}
}
package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.LoginValidation;
import org.apache.log4j.Logger;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;


public class LoginValidationImpl implements LoginValidation{
	private static Logger log = Logger.getLogger(LoginValidation.class);
	@Override
	public Customer isValidUser(String s)  throws BusinessException {
		Customer customer=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select id,firstname,lastname,email,password from customer where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,s);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer =new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
			}else {
				throw new BusinessException("Entered player id "+s+" doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customer;
	}

}

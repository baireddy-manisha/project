package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerRegDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;

public class CustomerRegDAOImpl implements CustomerRegDAO{
private static Logger log = Logger.getLogger(CustomerRegDAOImpl.class);

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

	@Override
	public Customer getCustomerById(int id) throws BusinessException {
		Customer customer=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select c.id,firstname,lastname,email,password from customer c where c.id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer=new Customer();
				customer.setId(id);
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				
				
			}else {
				throw new BusinessException("Entered id "+id+" doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomerByFirstname(String firstname) throws BusinessException {
		List<Customer> customerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select c.id,firstname,lastname,email,password from customer c where c.firstname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,firstname);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			
			}
			if(customerList.size()==0) {
				throw new BusinessException("No customers with first name"+firstname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customerList;
	}
		
	@Override
	public List<Customer> getCustomerByLastname(String lastname) throws BusinessException {
		List<Customer> customerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select c.id,firstname,lastname,email,password from customer c where c.lastname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,lastname);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			
			}
			if(customerList.size()==0) {
				throw new BusinessException("No customers with "+lastname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customerList;
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) throws BusinessException {
		List<Customer> customerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select c.id,firstname,lastname,email,password from customer c where c.email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			
			}
			if(customerList.size()==0) {
				throw new BusinessException("No Customers with email "+email);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customerList;
	}

	@Override
	public List<Customer> getCustomerByPassword(String password) throws BusinessException {
		List<Customer> customerList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select c.id,firstname,lastname,email,password from customer c where c.password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,password);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer=new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			
			}
			if(customerList.size()==0) {
				throw new BusinessException("No Customers with password "+password);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customerList;
	}
}

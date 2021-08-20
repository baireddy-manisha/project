package com.app.search.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.app.dao.CustomerRegDAO;
import com.app.dao.impl.CustomerRegDAOImpl;

import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.search.service.CustomerRegSearchService;

public class CustomerRegSearchServiceImpl implements CustomerRegSearchService {
	private CustomerRegDAO customerRegDAO =new CustomerRegDAOImpl();
	@Override
	public Customer getCustomerById(int id) throws BusinessException {
		Customer customer=null;
		if(id<500||id>1000) {
			throw new BusinessException("Invalid Customer Id "+id);
		}else {
			//code here to DAO
			customer=customerRegDAO.getCustomerById(id);
			
		}
		return customer;
		
	}

	
	@Override
	public List<Customer> getCustomerByFirstname(String firstname) throws BusinessException {
		List<Customer> customerList=null;
		if(firstname.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			customerList=customerRegDAO.getCustomerByFirstname(firstname);
		}else {
			throw new BusinessException("Invalid  product name : "+firstname);
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getCustomerByLastname(String lastname) throws BusinessException {
		List<Customer> customerList=null;
		if(lastname.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			customerList=customerRegDAO.getCustomerByPassword(lastname);
		}else {
			throw new BusinessException("Invalid  product name : "+lastname);
		}
		return customerList;
	
	}
		
	@Override
	public List<Customer> getCustomerByEmail(String email) throws BusinessException {
		List<Customer> customerList=null;
		if(email.matches("[a-zA-Z0-9'@'a-zA-Z.com]{2,20}")) {
			//code here to DAO
			customerList=customerRegDAO.getCustomerByPassword(email);
		}else {
			throw new BusinessException("Invalid  product name : "+email);
		}
		return customerList;
	
	}
		
	@Override
	public List<Customer> getCustomerByPassword(String password) throws BusinessException {
		List<Customer> customerList=null;
		if(password.matches("[a-zA-Z0-9]{2,10}")) {
			//code here to DAO
			customerList=customerRegDAO.getCustomerByPassword(password);
		}else {
			throw new BusinessException("Invalid  product name : "+password);
		}
		return customerList;
	}
}

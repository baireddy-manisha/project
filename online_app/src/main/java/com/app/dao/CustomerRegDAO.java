package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;


public interface CustomerRegDAO {
	public Customer getCustomerById(int id) throws BusinessException;
	public List<Customer> getCustomerByFirstname(String firstname) throws BusinessException;
	public List<Customer> getCustomerByLastname(String lastname) throws BusinessException;
	public List<Customer> getCustomerByEmail(String email) throws BusinessException;
	public List<Customer> getCustomerByPassword(String password) throws BusinessException;
	public int createAccount(Customer customer) throws BusinessException;
}
	

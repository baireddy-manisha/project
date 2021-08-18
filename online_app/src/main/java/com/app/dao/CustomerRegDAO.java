package com.app.dao;
import com.app.exception.BusinessException;
import com.app.model.Customer;


public interface CustomerRegDAO {
	public int createAccount(Customer customer) throws BusinessException;
}
	

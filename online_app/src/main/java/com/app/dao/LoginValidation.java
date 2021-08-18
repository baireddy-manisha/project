package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface LoginValidation {
	public Customer isValidUser(String s)  throws BusinessException ;
}
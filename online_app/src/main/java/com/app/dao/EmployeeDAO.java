package com.app.dao;
import java.util.List;
import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Product;

public interface EmployeeDAO {
	public int Addproduct(Product product) throws BusinessException;
	public List<Product> getAllProducts() throws BusinessException;	

}

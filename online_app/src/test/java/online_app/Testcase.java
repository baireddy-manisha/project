package online_app;

import static org.junit.jupiter.api.Assertions.*;
import com.app.search.service.ProductSearchService;
import com.app.search.service.impl.ProductSearchServiceImpl;
import com.app.search.service.CustomerRegSearchService;
import com.app.search.service.impl.CustomerRegSearchServiceImpl;
import org.junit.jupiter.api.Test;
import com.app.exception.*;
public class Testcase {
 ProductSearchService productSearchService=new ProductSearchServiceImpl();
 CustomerRegSearchService customerRegSearchService=new CustomerRegSearchServiceImpl();
	@Test
	public void test1() throws BusinessException {
		
	assertNotNull(productSearchService.getProductByProduct_name("LG"));
	}
	@Test
	public void test2() throws BusinessException {
		
	assertNotNull(productSearchService.getProductByProduct_id(1));
	}
	@Test
	public void test3() throws BusinessException {
		
	assertNotNull(productSearchService.getProductByCategory("clothing"));
	}
	@Test
	public void test4() throws BusinessException {
		
	assertNotNull(productSearchService.getProductByQuantity(10f));
	}
	@Test
	public void test5() throws BusinessException {
		
	assertNotNull(productSearchService.getProductByPrice(20000));
	}
	@Test
	public void test6() throws BusinessException {
		
	assertNotNull(productSearchService.getProductByRating(4.5f));
	}
	
	@Test
	public void test7() throws BusinessException {
		
	assertNotNull(customerRegSearchService.getCustomerById(501));
	}
	@Test
	public void test8() throws BusinessException {
		
	assertNotNull(customerRegSearchService.getCustomerByFirstname("manisha"));
	}
	
}

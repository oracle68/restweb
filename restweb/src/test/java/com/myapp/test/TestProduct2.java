package com.myapp.test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.myapp.dao.ProductDao;
import com.myapp.model.Product;
//runner de mockito que detecta las anotaciones
@RunWith(MockitoJUnitRunner.class)
//@RunWith(JUnit4.class)
public class TestProduct2 {
	@Rule 
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock 
	ProductDao productDao;
	// id valido de sistema
    private static final String validId = "12345";
    
	@Before 
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() throws Exception
	{
		Long id=1L;
		String name="P22";
		String description ="Desc 22";
		Double price=220.0;
		Product p = productDao.getById(id); //new Product(id,name,description,price);
		//Long id2=productDao.getById(p.getId());
		
		when(productDao.getById(p.getId())).thenReturn(p);
	}
}

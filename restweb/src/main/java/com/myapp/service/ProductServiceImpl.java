package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.ProductDao;
import com.myapp.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService { 
  
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getById(long Id) { 

		return productDao.getById(Id);
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override

	public void  add(Product product) {
		productDao.add(product);

	}

	@Override
	public void delete(long Id) {
		productDao.delete(Id);

	}

	@Override
	public void update(Product product) {
		productDao.update(product);
		
	}

}

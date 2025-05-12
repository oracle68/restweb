package com.myapp.dao;

import java.util.List;

import com.myapp.model.Product;

public interface ProductDao {

	 public Product getById(Long Id);
	 public void add(Product product);
	 public void update(Product product);
	 public void delete(Long Id);
	 public List<Product> findAll();
}

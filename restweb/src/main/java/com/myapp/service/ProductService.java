package com.myapp.service;

import java.util.List;

import com.myapp.model.Product;

public interface ProductService {

	Product getById(long Id);

	List<Product> findAll();

	void add(Product product);

	void delete(long Id);
	
	void update(Product product);

}
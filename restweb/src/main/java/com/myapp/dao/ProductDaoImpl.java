package com.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao{

	 Session  session=HibernateUtil.getSessionFactory().getCurrentSession();
	 final Transaction tx = session.beginTransaction();
	 
	 public Product getById(Long Id) {
		 
		 return (Product) session.get(Product.class, Id);
		 
	 }; 
	 public void add(Product product) {
		 this.session.save(product);		 
	 };
	 public void update(Product product){
		 this.session.update(product);		 
	 };
	 public void delete(Long Id){
		 this.session.delete(Id);		 
	 };
	 
	 public List<Product> findAll(){
		 return this.session.createQuery("from Products").list();		 
	 };	

}

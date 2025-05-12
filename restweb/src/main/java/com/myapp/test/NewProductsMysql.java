package com.myapp.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtilMysql;

public class NewProductsMysql {
	
	public static void main (String args[])
	{
		new NewProductsMysql().newProducts();
	}
	
	public void newProducts()
	{
		
		Long id=3L;
		String name="P17";
		String description ="Desc 17";
		Double price=20.0;
		Product p = new Product(id,name,description,price);
		Product p2 = new Product(id,"P11","Desc 11",50.0);
		Product p3 = new Product(id,"P13","Desc 13",70.0);
		Product p5 = new Product(id,"P19","Desc 19",70.0);
		Session session = HibernateUtilMysql.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    session.save(p);
	    session.save(p2);
	    session.save(p3);
	    
	    String sql = "SELECT * FROM products";
	    SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Product.class));	    
	    query.addEntity(Product.class);
        List<Product> products = query.list();

        for (Iterator iterator = products.iterator(); iterator.hasNext();){
           Product product = (Product) iterator.next(); 
           System.out.println(product.toString()); 
        }
 	    
	    tx.commit();
	    
	}

}

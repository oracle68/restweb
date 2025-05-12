package com.myapp.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.Pelis;
import com.myapp.model.Product;
import com.myapp.util.HibernateUtilPostGres;

public class TestPG {

	public TestPG() {
	}

	public static void main(String[] args) {
		Session session = HibernateUtilPostGres.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    
		/*Long id=3L;
		String name="P17";
		String description ="Desc 17";
		Double price=20.0;
		Product p = new Product(id,name,description,price);
		Product p2 = new Product(id,"Prod ","Desc ",20.0);
		Product p3 = new Product(id,"Prod ","Desc ",30.0);
		Product p5 = new Product(id,"Prod ","Desc ",40.0);
		Pelis pe =new Pelis(id,"Peli 4","Desc 4"); 
		Pelis pe1 =new Pelis(id,"Peli 5","Desc 5"); 

	    session.save(pe);
	    session.save(pe1);
	    session.save(p2);
	    session.save(p3);
	    String sql = "SELECT * FROM public.pelis";
	    SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Pelis.class));	    
	    query.addEntity(Pelis.class);
	    List<Pelis> peliss = query.list();

	    for (Pelis var: peliss){
	       System.out.println(var.toString()); 
	    }
	    sql = "SELECT * FROM public.products";
	    query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Product.class));	    
	    query.addEntity(Product.class);
	    List<Product> products = query.list();

	    for (Iterator iterator = products.iterator(); iterator.hasNext();){
	       Product product = (Product) iterator.next(); 
	       System.out.println(product.toString()); 
	    }  */
		
	    String sql = "SELECT table_name FROM information_schema.tables where table_schema='public'";
	    SQLQuery query = session.createSQLQuery(sql);

	    List<String> result = query.list();

	    for (String var: result){
	       System.out.println(var.toString()); 
	    }	    
	    tx.commit();
	    


	}


}

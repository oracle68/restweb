package com.myapp.test;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.modelpg.ProductPG;
import com.myapp.modelpg.Usuaris;
import com.myapp.util.HibernateUtilPG;

public class TestPGcloud {

	public TestPGcloud() {
	}

	public static void main(String[] args) {
		Long id=3L;
		String name="Josh";
		String address ="bcn 47";
		String gender ="male";
		String email =name+"@email.com";
		Integer age = 47;
        
		Integer i =4;
		String namePG="prod "+i;
		String description= "Desc "+i;
		Integer qty = i;
		Double price=20.0;
		Date fecha = new Date(); 
		ProductPG p = new ProductPG (id,namePG,description,price,qty,fecha);
		
		i =i+1;
		namePG="prod "+i;
		description= "Desc "+i;
		qty = i;
		price=30.0;
		

		ProductPG p2 = new ProductPG (id,namePG,description,price,qty,fecha);
		Usuaris u = new Usuaris(id,name,age,gender,address,email);
		Session session = HibernateUtilPG.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    
	    //String Update = "update product set email = 'Jamesemail.com' where id = 8";
	    Usuaris usu = (Usuaris) session.get("com.myapp.modelpg.Usuaris", 7L);
	    usu.setEmail("Jonh@email.com");
	    session.update(usu);
	    
	    //session.save(p);
	    //session.save(p2);
	    String sql = "SELECT * FROM public.usuaris";
	    SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Usuaris.class));	    
	    query.addEntity(Usuaris.class);
	    List<Usuaris> usus = query.list();

	    for (Usuaris var: usus){
	       System.out.println(var.toString()); 
	    }

	    sql = "SELECT * FROM public.product";
	    query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(ProductPG.class));	    
	    query.addEntity(ProductPG.class);
	    List<ProductPG> prods = query.list();

	    for (ProductPG var: prods){
	       System.out.println(var.toString()); 
	    }
	    
/*	    sql = "SELECT * FROM public.products";
	    query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Product.class));	    
	    query.addEntity(Product.class);
	    List<Product> products = query.list();

	    for (Iterator iterator = products.iterator(); iterator.hasNext();){
	       Product product = (Product) iterator.next(); 
	       System.out.println(product.toString()); 
	    }
*/	      	    
	    tx.commit();
	    


	}


}

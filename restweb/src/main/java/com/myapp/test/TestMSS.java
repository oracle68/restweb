package com.myapp.test;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.modelsqlserver.ItemMSS;
import com.myapp.modelsqlserver.ProductMSS;
import com.myapp.modelsqlserver.UsuarisMSS;
import com.myapp.util.HibernateUtilMSSQL;

public class TestMSS {

	public TestMSS() {
	}

	public static void main(String[] args) {
		Session session = HibernateUtilMSSQL.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    
		Long id=3L;        
		Integer i =6;
		String namePG="prod "+i;
		String description= "Desc "+i;
		Integer qty = i;
		Double price=20.0;
		Date fecha = new Date(); 
		ProductMSS p = new ProductMSS (id,namePG,description,price,qty,fecha);
		
		i =i+1;
		namePG="prod "+i;
		description= "Desc "+i;
		qty = i;
		price=30.0;


		String name="Maria";
		Integer age = 28;
		String address ="bcn "+age;
		String gender ="female";
		String email =name+"@email.com";
		

		Long id2=4L;
		Integer age2 = 29;
		String name2="Andrew";
		String address2 ="bcn "+age;
		String gender2 ="male";
		String email2 =name2+"@email.com";
		

		Long id3=4L;
		Integer age3 = 32;
		String name3="Sonia";
		String address3 ="bcn "+age;
		String gender3 ="female";
		String email3 =name3+"@email.com";
		

		ProductMSS p2 = new ProductMSS (id2,namePG,description,price,qty,fecha);
	    
	    //String Update = "update product set email = '@email.com' where id = 8";
	    //UsuarisMSS usu = (UsuarisMSS) session.get("com.myapp.modelpg.Usuaris", 7L);
	    //usu.setEmail("Jonh@email.com");
	    //session.update(usu);
		UsuarisMSS usu = new UsuarisMSS(id,name,age,gender,address,email);
		UsuarisMSS usu2 = new UsuarisMSS(id2,name2,age2,gender2,address2,email2);
		UsuarisMSS usu3 = new UsuarisMSS(id3,name3,age3,gender3,address3,email3);		
		//session.save(usu);
		//session.save(usu2);
		//session.save(usu3);
	    //session.save(p);
	    //session.save(p2);
	    
	    String sql = "SELECT * FROM usuaris";
	    SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(UsuarisMSS.class));	    
	    query.addEntity(UsuarisMSS.class);
	    List<UsuarisMSS> usus = query.list();

	    for (UsuarisMSS var: usus){
	       System.out.println(var.toString()); 
	    }

	    sql	="update Product set description = 'Descr' where description is null";
		SQLQuery queryUpdate = session.createSQLQuery(sql);
		int result = queryUpdate.executeUpdate();
		 System.out.println("Update product "+result); 
		sql	="update item set description = 'Descr' where description is null";
		
		 queryUpdate = session.createSQLQuery(sql);
		 result = queryUpdate.executeUpdate();
		 System.out.println("Update item "+result);
		
	    sql = "SELECT * FROM product";
	    query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(ProductMSS.class));	    
	    query.addEntity(ProductMSS.class);
	    List<ProductMSS> prods = query.list();

	    for (ProductMSS var: prods){
	       System.out.println(var.toString()); 
	    }
	    

	    sql = "SELECT * FROM item";
	    query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(ItemMSS.class));	    
	    query.addEntity(ItemMSS.class);
	    List<ItemMSS> items = query.list();

	    for (ItemMSS var: items){
	       System.out.println(var.toString()); 
	    }	    

	    tx.commit();	
	}


}

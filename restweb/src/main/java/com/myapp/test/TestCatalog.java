package com.myapp.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.Cat;
import com.myapp.util.HibernateUtil;

public class TestCatalog {
	
	 public static void main(String[] args)
	{
		new TestCatalog().test();
	}
	
	public void test()
	{
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    final Transaction tx = session.beginTransaction();
	String sql ="SELECT * from user_catalog";
	SQLQuery query = session.createSQLQuery(sql);
    query.setResultTransformer(Transformers.aliasToBean(Cat.class));	    
    query.addEntity(Cat.class);		
	List <Cat> l = query.list();
	for (Cat var: l)
	{
		System.out.println(var.toString());	
	}
	
	}
	//tx.commit();
}

package com.myapp.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.UserObjects;
import com.myapp.util.HibernateUtil;

public class TestUserObjects {

	public static void main (String args[])
	{
		test();
	}
	public static void test()
	{
		try
		{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    
		//String sql ="SELECT * from User_Objects";
	    String sql ="SELECT uo.object_Name,uo.object_Type,uo.last_Ddl_Time from User_Objects uo"; // where uo.object_type='TABLE'";
		SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(UserObjects.class));	    
	    query.addEntity(UserObjects.class);		
	    query.setMaxResults(50);
	    
		List<UserObjects> ad = query.list();
		for (UserObjects var: ad)
		{
			System.out.println(var.toString());	
		}
		System.out.println("Total filas:"+ad.size());
		System.out.println("---------------------------------------------------------");
		Stream<String> stream = Stream.of(ad.toString());
		//stream.forEach(s -> System.out.println(s));
		// Print the stream 
        System.out.println(stream.collect(Collectors.toList())); 		
		tx.commit();
		}catch (Exception ex) {ex.printStackTrace();}
	}
}

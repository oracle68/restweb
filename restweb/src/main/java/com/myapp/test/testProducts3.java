package com.myapp.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;

public class testProducts3 {


	  Session session;


		
	public static void main(String[] args) {
			new testProducts3().test();
				
	}
	
	public void test()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Product> pList = session.createQuery("from Product").list(); 
		for (Product var: pList)
		{
			System.out.println(var.toString());	
		}	
	}

}

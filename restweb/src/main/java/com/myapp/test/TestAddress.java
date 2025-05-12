package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.Address;
import com.myapp.model.Customer;
import com.myapp.util.HibernateUtil;

public class TestAddress {

	public static void main (String[] args)
	{
		new TestAddress().test();
	}
	
	public void test()
	{
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    final Transaction tx = session.beginTransaction();
		String sql ="SELECT * from address";
		SQLQuery query = session.createSQLQuery(sql);
	    //query.setResultTransformer(Transformers.aliasToBean(Address.class));	    
	    query.addEntity(Address.class);		
	    //query.addEntity(Customer.class);
	    List<Address> adrs = query.list();
	    
		for (Address var: adrs)
		{
			System.out.println(var.toString());	
		}
			    
	    Criteria criteria = session.createCriteria(Address.class);	    
	    List<Address> ad = criteria.list();
		for (Address var: ad)
		{
			System.out.println(var.toString());	
		}
		
		tx.commit();
	}
}

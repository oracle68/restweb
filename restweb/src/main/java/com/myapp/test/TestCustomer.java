package com.myapp.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.myapp.model.Address;
import com.myapp.model.Customer;
import com.myapp.util.HibernateUtil;

public class TestCustomer {

	public static void main (String[] args) {
		
	 new TestCustomer().tc();	
	}
	
	public void tc() 
	{
		List<Address> adr= new ArrayList<Address>();
		Long id=1L;
		String firstname="Helena";
		String lastname="Helena";
		String password="passwd";
		
        String country="Catalonia";
        String adreca="Girona";
        String zipCode="00000";
        Boolean save =true;
		Customer c = new Customer(id,firstname,lastname,password,adr);
        Address a = new Address(id,c,country,adreca,zipCode);
        adr.add(a);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    
	    if (save) { 
		    session.save(c);
		    session.save(a);
	    }    
	    Criteria criteria = session.createCriteria(Customer.class);
	    Criteria crit = session.createCriteria(Address.class);	    
		List<Customer> cList = criteria.list();
		for (Customer var: cList)
		{
			System.out.println(var.toString());	
		}
		List<Address> aList = crit.list();
		for (Address var: aList)
		{
			System.out.println(var.toString());	
		}		
		
		Address ad = (Address) crit.add(Restrictions.eq("id", 28L) ).uniqueResult();
		System.out.println(ad.toString());
		
		String sql ="SELECT * from customer";
		SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Customer.class));	    
	    //query.addEntity(Address.class);		
	    query.addEntity(Customer.class);
	    List<Customer> cust = query.list();
	    
		for (Customer var: cust)
		{
			System.out.println(var.toString());	
		}		
	    tx.commit();
			
	}
	
}

package com.myapp.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.Address;
import com.myapp.model.Customer;
import com.myapp.model.CustomerAddress;
import com.myapp.util.HibernateUtil;

public class TestCustomerAddress {

	public static void main (String args[]) {
		
		 new TestCustomerAddress().tc();	
		}
		
		public void tc() 
		{
			Long id=48L;
			String name="Maria Maria";
			String firstname="Maria4";
			String lastname="Maria4";
			String password="passwd";
	        String country="Catalonia";
	        String address="Girona";
	        String zipCode="00000";
	        Boolean save =true;
	        List<Address> adr= new ArrayList<Address>();	        
			Customer c = new Customer(id,firstname,lastname,password,adr);
			Customer c2 = new Customer(id,firstname,lastname,password,adr);
	        Address a = new Address(id,c,country,address,zipCode);
	        adr.add(a);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    final Transaction tx = session.beginTransaction();
		    
		  /*  if (save) {
		    	//sessio.delete(a);
			    //session.delete(c);
			    //session.save(c);
			    //session.save(a);
		    }
		    */    	   
//		    System.out.println("SELECT a.* from address a,customer c where a.fk_customer=c.id");
  //String sql ="SELECT c.* from Address a,Customer c where c.id=a.Customer.id";
  //String sql="select a.id as Id from address a, customer c where a.FK_CUSTOMER=c.id";
		    String sql="select * from address a";
			SQLQuery query = session.createSQLQuery(sql);
		    //query.setResultTransformer(Transformers.aliasToBean(Address.class));	    
		    query.addEntity(Address.class);		
		    //query.addEntity(Customer.class);
		  
		    //Criteria crit= session.createCriteria(Address.class);		    
			List<Address> ad = query.list();
			for (Address var: ad)
			{
				System.out.println(var.toString());	
			}
			
			System.out.println("SELECT * from CustomerAddress");
			sql ="SELECT * from CustomerAddress";
			query = session.createSQLQuery(sql);
		    query.setResultTransformer(Transformers.aliasToBean(CustomerAddress.class));	    
		    query.addEntity(CustomerAddress.class);		

			List<CustomerAddress> cList = query.list();
			for (CustomerAddress var: cList)
			{
				System.out.println(var.toString());	
			}
	
		    tx.commit(); 
				
		}	
}

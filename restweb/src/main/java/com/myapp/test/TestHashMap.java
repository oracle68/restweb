package com.myapp.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;

public class TestHashMap {

	public static void main (String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    Criteria crit = session.createCriteria(Product.class);
	    List<Product> p = crit.list();
	    Map<Long, String> m = new HashMap<Long, String>();
	 // Definir un HashSet
        HashSet h = new HashSet();
	    for (Product var:p)
	    {
	    	h.add(var); 
	    	System.out.println(h);
	    	//m.put(var.getId(), var.getDescription());
	    	//System.out.println(m);
	    	
	    }	
	    
	    
	}

}

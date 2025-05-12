package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import com.myapp.model.Usuario;
import com.myapp.util.HibernateUtil;

public class TestCriteriaBuilder {

	public TestCriteriaBuilder() {
		// TODO Auto-generated constructor stub
	}
	public static void main (String[] args)
	{
		new TestCriteriaBuilder().test();

	}

	public static void test()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	 /*   CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<User> query = builder.createQuery(User.class);
	    Root<User> root = query.from(User.class);
	    query.select(root);
	    query.select(root).where(builder.isNotNull(root.get("adresa")));
	    Query<User> q = session.createQuery(query);
     */
	   Criteria crit = session.createCriteria(Usuario.class);
	   
       List<Usuario> list = crit.list();
	    
	    for (Usuario var:list) {
	    	System.out.println(var.toString());
	    	
	    }	
	    
		   Criteria crit2 = session.createCriteria(Usuario.class);
		   
	       List<Usuario> list2 = crit2.list();
		    
		    for (Usuario var2:list2) {
		    	System.out.println(var2.toString());
		    	
		    }	    
	    tx.commit();		
		
	}
}

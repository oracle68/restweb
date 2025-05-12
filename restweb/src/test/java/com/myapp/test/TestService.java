package com.myapp.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;

public class TestService {



		public TestService() {
	    }

	    public int check() {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    final Transaction tx = session.beginTransaction();
	    	String sql="SELECT * FROM PRODUCTS";
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setResultTransformer(Transformers.aliasToBean(Product.class));	    
		    query.addEntity(Product.class);
		    List<Product> products = query.list();
		    int l = products.size();
		    System.out.println("Total filas: "+l);
		    tx.commit();
	        return l;
	    }
	    public static void main (String args[])
	    {
	    	new TestService().check();
	    }		
	    
	  public int check2()
	    {
	    	return 17;
	    }
	 
	
}

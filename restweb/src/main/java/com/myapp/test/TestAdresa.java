package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Adresa;
import com.myapp.util.HibernateUtil;

public class TestAdresa {

	public TestAdresa() {
		
	}

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    Adresa adr = new Adresa(1L,"Carrer de Barcelona)"); 
	    session.save(adr);

	    Criteria crit = session.createCriteria(Adresa.class);
	    List<Adresa> lista =crit.list();
	    for (Adresa var:lista) {
	    	System.out.println(var.toString());
	    }
	    tx.commit(); 	
	    
	}
	
	public static void test()
	{
		
		
	}

}

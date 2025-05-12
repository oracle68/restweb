package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.model.Pelis;
import com.myapp.util.HibernateUtil;

public class TestPelis {

	public TestPelis() {
		// TODO Auto-generated constructor stub
	}
	public static void main (String[]  args)
	{
		new TestPelis().save();
	}
	public void save ()
	{
		Long id=1L;
		String nom="Peli 2";
		String descripcio ="Desc 2";

		Pelis p = new Pelis(id,nom,descripcio);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    session.save(p);
	    Criteria criteria = session.createCriteria(Pelis.class);
		criteria.add(Restrictions.like("nom","%",MatchMode.ANYWHERE));
		List<Pelis> pList = criteria.list();
		for (Pelis var: pList)
		{
			System.out.println(var.toString());	
		}		
	    tx.commit();
	  
			  
	}  
}

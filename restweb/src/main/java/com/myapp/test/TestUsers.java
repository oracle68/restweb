package com.myapp.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.myapp.model.Adresa;
import com.myapp.model.City;
import com.myapp.model.Provincia;
import com.myapp.model.Usuario;
import com.myapp.util.HibernateUtil;

public class TestUsers {

	public TestUsers() {
		
	}
	
	public static void main (String args[]) throws Exception
	{
		
		new TestUsers().test();
	}
	public void test() throws  FileNotFoundException
	{
		List <Usuario> us = new ArrayList<>(); 
		Long userId=1L;
		String firstName="Pep2";
		String lastName="Pep2";
		String gender="Male2";
		String city ="Barcelona";
		Date fecha=null;
		 		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    City cityBean= (City) session.get(City.class, 21L);
	    Adresa adr = (Adresa) session.get(Adresa.class, 136L); 
	    Provincia provincia = null; //(Provincia) session.get(Provincia.class, "08");
	    Usuario user = new Usuario(); //( userId, city,firstName,lastName,gender,cityBean, provincia,adr);
	    Provincia prv = new Provincia ("06","Lleida");
	    session.saveOrUpdate(prv);
	    prv.setNom("Lleida");
	    session.save(user);
	    session.saveOrUpdate(prv);
	    Criteria crit = (Criteria) session.
	    		createCriteria(Usuario.class).
                setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);	
	            crit.add(Restrictions.isNotNull("adresa"));	 
	            crit.add(Restrictions.isNotNull("cityBean"));
	            crit.add(Restrictions.isNotNull("provincia"));
        us = crit.list();
        
        System.out.println("Total filas= "+us.size());
        for (Usuario var:  us){
           System.out.println(var.toString());
        }

	    String sql = "select codi,nom from provincia";
	    SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Provincia.class));	    
	    query.addEntity(Provincia.class);
	    List <Provincia> pr = query.list();
	    System.out.println("Total provincias= "+pr.size());
	    for (Provincia var:  pr){
	           System.out.println(var.toString());
	        }
	    System.out.println("Provincia criteria list");
	    Criteria criter = (Criteria) session
	    		.createCriteria(Provincia.class)
	    		//.add(usuarios == null ? Restrictions.isNull("status") : Restrictions.eq("status", status)
	    		.add(Restrictions.isEmpty("usuarios"));	    
        pr= criter.list();
	    for (Provincia var:  pr){
	           System.out.println(var.toString());
	        }
	    
		sql ="SELECT u.* from usuarios u where u.idcity is not null ";
		query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Usuario.class));	    
	    //query.addEntity(Address.class);		
	    query.addEntity(Usuario.class);
	    List<Usuario> cust = query.list();
	    
		for (Usuario var: cust)
		{
			System.out.println(var.toString());	
		}	
		
	    tx.commit();
	    if (session.isOpen())
	    {
	    	session.close();
	    }	
	    
	}
}

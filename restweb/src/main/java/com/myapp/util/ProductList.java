package com.myapp.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.model.Product;

public class ProductList {

	
	public List<Product> pList() {

		Session sessio = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = sessio.beginTransaction();
	    Criteria criteria = sessio.createCriteria(Product.class);
		criteria.add(Restrictions.like("name","%",MatchMode.ANYWHERE));
		criteria.add(Restrictions.ge("price", 1.0));
		List<Product> pList = criteria.list();
		Collections.sort(pList, new Sortbyroll()); 
		tx.commit();
		return pList;
	}
	public String tableList()
	{
		List<Product> pList = pList();	
        String message=" <table border='1'>\n" + 
    	   		"<tr><td>ID</td><td>Name</td><td>Description</td><td>Price</td></tr>";   
	    
        for (Iterator iterator = pList.iterator(); iterator.hasNext();){
           Product product = (Product) iterator.next(); 
           message+="\n<tr><td>"+product.getId()+"</td><td>"+product.getName()+"</td><td>"+product.getDescription()+"</td><td>"+product.getPrice()+"</tr>"; 
        }  
        message+="</table>";
        return message;
		
		
	}

}

package com.myapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Address;
import com.myapp.model.Customer;
import com.myapp.util.HibernateUtil;

@RestController
public class AddressController {

  	@GetMapping("/addressList")
  	
  	public void getList(HttpServletResponse response) throws IOException
  	
  	{ 
  		PrintWriter out = response.getWriter();
	    response.setHeader("Custom-Header", "Header");
	    response.setStatus(200);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
  		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
 
	    Criteria criteria = session.createCriteria(Customer.class);
	    Criteria crit = session.createCriteria(Address.class);	    
		List<Customer> cList = criteria.list();
		for (Customer var: cList)
		{
			out.println(var.toJson());	
		}
		List<Address> aList = crit.list();
		for (Address var: aList)
		{
			response.getWriter().println(var.toString());	
		}		
		
		Address ad = (Address) crit.add(Restrictions.eq("id", 28L) ).uniqueResult();
		response.getWriter().println(ad.toJson());
		
	    tx.commit();  		
  		
	    
  	}
}

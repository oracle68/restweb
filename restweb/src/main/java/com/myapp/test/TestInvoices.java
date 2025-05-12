package com.myapp.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Customer;
import com.myapp.model.Invoice;
import com.myapp.model.InvoiceLine;
import com.myapp.model.Status;
import com.myapp.util.HibernateUtil;

public class TestInvoices {

	public static void main(String[] args) {
		try
		{
			System.out.println("Inicio"); 
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    final Transaction tx = session.beginTransaction();
		    Invoice invoice = new Invoice();
		    
		    List<InvoiceLine> lines = new ArrayList<>();
		    for(int c = 0; c<10; c++){
		        InvoiceLine line = new InvoiceLine();
		        line.setInvoice(invoice);
		        line.setPrice(12);
		        line.setProduct("Product " + (c+1));
		        line.setQuantity(c+1);
		        lines.add(line);
		    }
	
		    Customer customer = new Customer();
		    customer.setFirstname("James");
		    customer.setLastname("James");
		    customer.setPassword("James");
		    
		    
		    invoice.setCustomer(customer);
		    invoice.setLines(lines);
		    invoice.setRegistDate(Calendar.getInstance());
		    invoice.setStatus(Status.ACTIVE);	
		    session.save(customer);
		    session.save(invoice);
		    
		    tx.commit();
		    System.out.println("Fin");
		    
		}catch(Exception ex) { ex.printStackTrace();}
		
	}

}

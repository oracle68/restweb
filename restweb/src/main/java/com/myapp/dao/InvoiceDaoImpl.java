package com.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.model.Invoice;

@Repository
public class InvoiceDaoImpl implements InvoiceDao{

	@Autowired
    SessionFactory sessionFactory;
	Session session;

	@Override
	public Invoice findById(long Id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Invoice invoice = (Invoice) session.get(Invoice.class, Id);
		return invoice;
	}
	@Override
	public List<Invoice> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Invoice> li = session.createQuery("From Invoice").list();
		return li; 
	}
	@Override
	public void addInvoice(Invoice invoice) {
		sessionFactory.getCurrentSession().save(invoice);
		
	}

	@Override
	public void deleteInvoice(long Id) {
		Invoice invoice = (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, Id); 
        if (null != invoice) {
            sessionFactory.getCurrentSession().delete(invoice);
        }
		
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		sessionFactory.getCurrentSession().update(invoice);
		
	}}
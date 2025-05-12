package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.model.Factura;

@Repository
public class FacturaDaoImpl implements FacturaDao{

	@Autowired
    private SessionFactory sessionFactory;

@Override
				public Factura findById(long Id) {
					Factura factura = (Factura) sessionFactory.getCurrentSession().get(Factura.class, Id);
					return factura;
				}
	@Override
	public List<Factura> findAll() {
		 return sessionFactory.getCurrentSession().createQuery("from Factura").list(); 
	}
	@Override
	public void addFactura(Factura factura) {
		sessionFactory.getCurrentSession().save(factura);
		
	}

	@Override
	public void deleteFactura(long Id) {
		Factura factura = (Factura) sessionFactory.getCurrentSession().get(Factura.class, Id); 
        if (null != factura) {
            sessionFactory.getCurrentSession().delete(factura);
        }
		
	}

	@Override
	public void updateFactura(Factura factura) {
		sessionFactory.getCurrentSession().update(factura);
		
	}}
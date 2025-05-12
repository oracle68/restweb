package com.myapp.dao;

import java.util.List;

import com.myapp.model.Factura;

public interface FacturaDao {

	Factura findById(long Id);

	List<Factura> findAll();

	void addFactura(Factura factura);

	void deleteFactura(long Id);
	
	void updateFactura(Factura factura);

}
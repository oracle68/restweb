package com.myapp.service;

import java.util.List;

import com.myapp.model.Factura;

public interface FacturaService {

	Factura findById(long Id);

	List<Factura> findAll();

	void addFactura(Factura factura);

	void deleteFactura(long Id);
	
	void updateFactura(Factura factura);

}
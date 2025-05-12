package com.myapp.dao;

import java.util.List;

import com.myapp.model.Invoice;

public interface InvoiceDao {

	Invoice findById(long Id);

	List<Invoice> findAll();

	void addInvoice(Invoice invoice);

	void deleteInvoice(long Id);
	
	void updateInvoice(Invoice invoice);

}
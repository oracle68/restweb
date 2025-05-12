package com.myapp.service;

import java.util.List;

import com.myapp.model.Invoice;

public interface InvoiceService {

	Invoice findById(long Id);

	List<Invoice> findAll();

	void addInvoice(Invoice invoice);

	void deleteInvoice(long Id);
	
	void updateInvoice(Invoice invoice);

}
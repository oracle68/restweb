package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.InvoiceDao;
import com.myapp.model.Invoice;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService { 

	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public Invoice findById(long Id) { 

		return invoiceDao.findById(Id);
	}

	@Override
	public List<Invoice> findAll() {
		return invoiceDao.findAll();
	}

	@Override
	public void addInvoice(Invoice invoice) {
		invoiceDao.addInvoice(invoice);

	}

	@Override
	public void deleteInvoice(long Id) {
		invoiceDao.deleteInvoice(Id);

	}

	@Override
	public void updateInvoice(Invoice invoice) {
		invoiceDao.updateInvoice(invoice);
		
	}

}

package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.myapp.model.Invoice;
import com.myapp.service.InvoiceService;
@EnableWebMvc
@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;  
	
	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@RequestMapping(value = "/invoiceList", method = RequestMethod.GET, produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllInvoice() {
		System.out.println("#########getAll()#########");
		List<Invoice> invoiceList = invoiceService.findAll();
		return invoiceList;
	}
	
}
package com.myapp.controller;

import java.util.ArrayList;
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
public class InvoiceAngularController {

   @Autowired
   private InvoiceService invoiceService;



	@RequestMapping(value="/invoiceListAngular", method = RequestMethod.GET)
	public String getLista() {
		System.out.println("***************invoiceListAngular");
		return "invoiceListAngular";
	} 
	


	@RequestMapping(value="/invoiceListJson", method = RequestMethod.GET,produces="application/json")
  	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List<Invoice> getListaProducts() {

  		List<Invoice> plista = new ArrayList <Invoice>(); 
  			plista = invoiceService.findAll();
  			for (Invoice var:plista) {
  				System.out.println(var.toString()); 
  			}
  		return plista;

	}  	
}

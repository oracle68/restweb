package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.Factura;
import com.myapp.service.FacturaService;

@Controller
public class FacturaController {

	@Autowired
	private FacturaService facturaService;      
	@RequestMapping(value = "/facturaListJson", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List getAllFactura() {
		System.out.println("#########getAll()#########");
		List<Factura> facturaList = facturaService.findAll();
		return facturaList;
	}
	
}
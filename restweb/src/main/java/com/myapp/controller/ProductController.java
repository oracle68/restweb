package com.myapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.model.Product;
import com.myapp.util.ProductList;


	@RestController
	public class ProductController {

 	
		
		@GetMapping("/productList")
		public void prList(HttpServletResponse response) throws IOException {


	        String message = new ProductList().tableList();			
		    response.setHeader("Custom-Header", "Header");
		    response.setStatus(200);
		    response.getWriter().println(message);
		}	
			
	  	@RequestMapping(value="/addProd", method = RequestMethod.GET)
		public ModelAndView addPr() {
	  		System.out.println("ini addPr");
	  		Map<String, Object> map = new HashMap<String, Object>();
	  		map.put("text", "prova");
	  		System.out.println("end addPr");
	 		return new ModelAndView("addProd", "map", map);

		}
	  	
	  	@RequestMapping(value="/addProd", method = RequestMethod.POST)
		public ModelAndView addPrPost() {
	  		System.out.println("ini addPr Post");
	  		Map<String, Object> map = new HashMap<String, Object>();
	  		map.put("text", "prova");
	  		System.out.println("end addPr Post");
	 		return new ModelAndView("addProd", "map", map);

		}  	
		
	}

package com.myapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.myapp.model.Product;

@Controller
public class ProductAngularController {

  	@RequestMapping(value="/productListAngular", method = RequestMethod.GET)
	public ModelAndView getLista() throws IOException {

  		List<Product> plista = new ArrayList<>();
  		
  		Product p = new Product(1L, "uno", "desc1", 10.0);
  		plista.add(p);
  		
  		p = new Product(2L, "dos", "desc2", 20.0);
  		plista.add(p);
  		p = new Product(3L, "tres", "desc3", 30.0);
  		plista.add(p);

  		
  		//ObjectMapper mapper = new ObjectMapper();
		//String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(plista);	  	
  		Gson gson = new Gson();
  		String result = gson.toJson(plista);
  		System.out.println(result);
 		return new ModelAndView("productListAngular", "lista",result );

	}
}

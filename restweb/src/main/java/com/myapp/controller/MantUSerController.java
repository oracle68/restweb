package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MantUSerController {

	@GetMapping("/MantUsers")
	public ModelAndView mantUser()  {
		
		return new ModelAndView("MantUsuarios");

	}
	@GetMapping("/InsUsers")
	public ModelAndView insUser()  {
		
		return new ModelAndView("InsUsuarios");

	}	
	
	@PostMapping("/InsUsers")
	public ModelAndView ins2User()  {
		
		return new ModelAndView("InsUsuarios");

	}		
}

package com.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.dao.UserDaoImpl;
import com.myapp.model.User;

@Controller
public class UserAngularController {

	UserDaoImpl udi = new UserDaoImpl();
	
	@GetMapping("/userListAngular")
	public ModelAndView getList() throws JsonProcessingException {
		List<User> userlist = udi.findAll(); 
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userlist);
		System.out.println(jsonString);
		return new ModelAndView("userListAngular","lista",jsonString);
	}
	
	
}

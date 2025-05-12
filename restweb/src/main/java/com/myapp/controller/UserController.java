package com.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.dao.UserDaoImpl;
import com.myapp.model.User;

@RestController
public class UserController {
    
	//@Autowired
	UserDaoImpl udi = new UserDaoImpl();
			
/*	@GetMapping("/users2/{id}")
	public ResponseEntity <User> getUserId2(@PathVariable("id") Long id)
	{
		City city = new City (id,"Barcelona");
        User user = new User(id,"John","Smith",city);
		if (id <= 7) {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "MyController");
            
            return ResponseEntity.accepted().headers(headers).body(user);            
        }
       
        return  ResponseEntity.badRequest().body(user);
	}
*/	
	@GetMapping("/users/{id}")
	public void getUserIdl(@PathVariable("id") Long id,HttpServletResponse response) throws IOException {

        User user=udi.getById(id);
	    response.setHeader("Custom-Header", "Header");
	    if (user==null)
	    {
	    	response.setStatus(404);
	    	response.getWriter().println("NOT FOUND");	    	
	    }	
	    else
	    	
	    {
	    	response.setStatus(200);
	    	response.getWriter().println(user);
	    }
	    
	}	
	
	@GetMapping("/usersbyname/{name}")
	public void getUserByNamel(@PathVariable("name") String name,HttpServletResponse response) throws IOException {
        User user=udi.getByName(name);
	    response.setHeader("Custom-Header", "Header");
	    if (user==null)
	    {
	    	response.setStatus(404);
	    	response.getWriter().println("NOT FOUND");	    	
	    }	
	    else
	    	
	    {
	    	response.setStatus(200);
	    	response.getWriter().println(user);
	    }
	    
	}	
	@GetMapping("/adduser/{nom}/{cognom}")
	public void getUserByNamel(@PathVariable("nom") String nom,@PathVariable("cognom") String cognom,
			    HttpServletResponse response) throws IOException {
        //UserDaoImpl udi =new UserDaoImpl();
        udi.add(nom,cognom);
	    response.setHeader("Custom-Header", "Header");
	    if (nom==null || cognom==null)
	    {
	    	response.setStatus(404);
	    	response.getWriter().println("NOT FOUND");	    	
	    }	
	    else
	    	
	    {
	    	response.setStatus(200);
	    	response.getWriter().println(udi.getUserlist());
	    }
	    
	}
	
	@GetMapping("/userList")
	public void userLis1(HttpServletResponse response) throws IOException {

		List<User> us = udi.findAll(); 
	    response.setHeader("Custom-Header", "userList");
	    response.setStatus(200);
	    response.getWriter().println(us);
	    response.getWriter().println(us.size());
	}	
	
	@GetMapping("/userList2")
	public void userList2(HttpServletResponse response) throws IOException {
  
		List<User> us = udi.getAll(); 
	    response.setHeader("Custom-Header", "userList");
	    response.setStatus(200);
	    response.getWriter().println(us);
	    response.getWriter().println(us.size());
	}		
	
	
}

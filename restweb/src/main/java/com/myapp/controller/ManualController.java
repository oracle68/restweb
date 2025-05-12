package com.myapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManualController {

	@GetMapping("/manual")
	public void manual(HttpServletResponse response) throws IOException {
	    response.setHeader("Custom-Header", "foo");
	    response.setStatus(200);
	    response.getWriter().println("Hello World!");
	}	
}

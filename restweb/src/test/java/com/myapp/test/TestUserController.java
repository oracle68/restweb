package com.myapp.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.myapp.controller.UserController;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserController {

	private final static Logger log = Logger.getLogger(TestController.class);
	// @Autowired 
	// UserController controller;


	 
	 HttpServletRequest request = mock(HttpServletRequest.class);       
     HttpServletResponse response = mock(HttpServletResponse.class);
     @Autowired
     private MockMvc mockMvc;
     @Mock
     private UserController controller;
     
	  @Test
	    public void contexLoads() throws Exception {
		  log.debug("ini");
		 // UserDaoImpl udi = new UserDaoImpl();
		 // List<User> us = udi.findAll();
	      // assertThat(controller).isNotNull();		  

		  log.debug("userList");
		   //when(controller.userLis1(response)).thenReturn("OK");
		   this.mockMvc.perform(get("/userList")).andDo(print()).andExpect(status().isOk());
		   log.debug("getParameter:"+ ((ServletRequest) response).getParameter("us"));
		   
	    }
	
}

package com.myapp.test;

import java.util.List;

import com.myapp.dao.UserDaoImpl;
import com.myapp.model.Usuario;

public class testUserList {

	public static void  main(String[] args) throws Exception
	{
      new testUserList().loadUserList();
	}
	
   public String loadUserList()
   {
	   String message=" <table>\n" + 
	   		"     <tr>\n" + 
	   		"     <td>ID</td><td>FirstName</td><td>LastName</td><td>City</td>\n" + 
	   		"     </tr>";   
    try
    {
  	UserDaoImpl udi = new UserDaoImpl();   
      List<Usuario> us = udi.findAll(); 
      for (Usuario var :us)
      {
    
      	message=message+"<tr><td>"+var.getUserId()+" </td><td>"+var.getFirstName()+"</td><td>"+var.getLastName()+"</td><td>"+
      	                 var.getCity().getNom()+"</td> </tr>";
        
            
      }
      message=message+"</table>";
      return message;
     }catch (Exception ex){ex.printStackTrace(); return null;}

    
   }
}

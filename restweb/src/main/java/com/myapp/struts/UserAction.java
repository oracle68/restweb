package com.myapp.struts;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myapp.dao.UserDaoImpl;
import com.myapp.model.Adresa;
import com.myapp.model.City;
import com.myapp.model.Provincia;
import com.myapp.model.User;


public class UserAction extends org.apache.struts.action.Action {
	
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    //@Autowired
    //private SessionFactory sessionFactory;




//@Autowired
//private ApplicationContext _applicationContext;

//Add below line in your calling method
//UserService userService = (UserService) _applicationContext.getBean("userService");

// Or you can simply use this, put the below code in your controller data member declaration part.
//@Autowired
//private UserService userService;
	private Long id=1L;
	   
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
		String msg="";
         // extract user data
        UserForm formBean = (UserForm)form;
      
        //System.out.println("********************************** VALOR:"+formBean.getValor());
        try {
        if (formBean.getValor()==null)
        {
        	System.out.println("**********************************No se ha pulsado SUBMIT");
        	formBean.setError("No se ha pulsado SUBMIT");
        	return mapping.findForward(FAILURE);

        }
        
        else
         {  // perform validation
            if (formBean.getFirstname().equals("")) // == null)  
               
            {  
                
            	msg="Campo firstname vacio<br>";
            }
            if (formBean.getLastname().equals("")) // == null)  
                
            {  
                
            	msg=msg+"Campo lastname vacio<br>";
            }
            
            if (formBean.getGender().equals("")) // == null)  
                
            {  
                
            	msg=msg+"Campo Gender vacio<br>";
            }

            if (formBean.getCity().equals("")) // == null)  
                
            {  
                
            	msg=msg+"Campo City vacio<br>";
            }
            
            if (!msg.equals(""))
            {
                formBean.setError(msg);   
                System.out.println("**********************************Campo firstname vacio");
                return mapping.findForward(FAILURE);
            }  
           else
            { 
        
        	   String firstname = formBean.getFirstname();
        	   String lastname = formBean.getLastname();
        	   //String gender = formBean.getGender();
        	   String nom = formBean.getCity();
        	   City city = new City(id,nom);
        	   Provincia prov = new Provincia("08",nom);
        	   Adresa adr = new Adresa(id,nom);
               String error = formBean.getError();  
               User user = new User(id,"Barcelona",firstname,lastname,"Male",city,prov,adr);


               System.out.println("**** UserAction DAO insert data user "+user.toString());
               //ApplicationContext context = new GenericXmlApplicationContext("spring-servlet.xml");
               //UserService myClass = applicationContext.getBean("userService");
               //UserService userService = (UserService) context.getBean("userService");
       		   //sessionFactory.getCurrentSession().save(user);              
               UserDaoImpl us = new UserDaoImpl();
               us.save(user);
               
        	   PrintWriter pw= response.getWriter();
      		   ServletContext contexto=request.getServletContext();
      		    pw.append("Served at: ").append(request.getContextPath());
                return mapping.findForward(SUCCESS);
                 }
          }   
          
            	
        }catch (java.lang.NullPointerException ex) 
        {  
           ex.printStackTrace(); 
           formBean.setError("Null error:");   
         
           return mapping.findForward(FAILURE);
        }
        catch (Exception ex) 
        {  
        	ex.printStackTrace();
        	formBean.setError(ex.getMessage());   
           return mapping.findForward(FAILURE);
        }
        
}

}
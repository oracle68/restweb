package com.myapp.struts;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class LogAction extends Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
             // extract user data
            LogForm formBean = (LogForm)form;
            String filePath = getServlet().getServletContext().getRealPath("/") +"upload";
            //System.out.println("********************************** VALOR:"+formBean.getValor());
            //System.out.println("*****file:"+formBean.getFile().getFileName());
            System.out.println("*****filepath:"+filePath);
            try {
            if (formBean.getValor()==null)
            {
            	System.out.println("**********************************No se ha pulsado SUBMIT");
            	formBean.setError("No se ha pulsado SUBMIT");
            	return mapping.findForward(FAILURE);

            }
            
            else
             {  // perform validation
	            if (formBean.getName().equals("")) // == null)       // name parameter does not exist
	               
	            {   // email lacks '@'
	                
	                formBean.setError("Campo vacio");   
	                return mapping.findForward(FAILURE);
	            }  
	           else
	            { 
	        	   String name = formBean.getName();
	               String error = formBean.getError();  
	               FormFile file = formBean.getFile(); 
	               
	        	   PrintWriter pw= response.getWriter();
	      		   ServletContext contexto=request.getServletContext();
	      		    pw.append("Served at: ").append(request.getContextPath());
	      		  pw.append("File: "+file);
	                return mapping.findForward(SUCCESS);
	            }
              }   
	          
	            	
            }catch (java.lang.NullPointerException ex) 
            {  formBean.setError("Null error");   
               return mapping.findForward(FAILURE);
            }
    }
}
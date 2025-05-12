package com.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;
import com.myapp.util.ProductList;


@WebServlet("/addProduct")
public class addProduct  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	final static Logger log = Logger.getLogger(addProduct.class); 	
	String valor="1";

	private String ini()
	{
	String html ="<html><head>" + 
			"<title>HTML Charset</title>" + 
			"<meta charset='utf-8'>\n" + 
			" <script type='text/javascript'>" + 
			"  function valida() {" + 
			"  if (document.f.nom.value=='')\n" + 
			"    { document.f.errname.value='camp name buit';" + 
			"    } else  document.f.errname.value='';" + 
			"  if (document.f.description.value=='')" + 
			"  { document.f.errdesc.value='camp description buit';" + 
			"  } else document.f.errdesc.value='';" + 
			"  if (document.f.price.value=='') " + 
			"    { document.f.errprice.value='camp price buit';" + 
			"    } else document.f.errprice.value='';" + 
			" if (f.nom.value!='' && f.description.value!='' && f.price.value!='')" + 
			"  {" + 
			"   alert ('submit');\n" + 
			"   f.action='addProduct';" + 
			"    f.valor.value=2 " +
			"   f.submit();" + 
			"  }" + 
			" return false;" + 
			"}" + 
			"</script>" + 
			"</head>" + 
			"<body>" + 
			" <form name='f' action='' method='post' onsubmit='return valida()' >" + 
			"Name <input type='text' name='nom'/> <input type='text' name='errname'/>" + 
			"<br>Desc<input type='text' name='description'> <input type='text' name='errdesc'/>" + 
			"<br>Price<input type='text' name='price'/> <input type='text' name='errprice'/>" + 
			"<br><input type='hidden' name='valor' value='1'/>" + 
			"<br><input type='submit' name='mybutton' />" + 
			"<br></form>" + 
			"</body>" + 
			"</html>";
    return html;
	}   
    /**  oninvalid='this.setCustomValidity('Camp Name obligatori')'
     * @see HttpServlet#HttpServlet()
     */
    public addProduct() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	 ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter(); //.append("Served at: ").append(request.getContextPath())
		
		Long id =1L;
		String errorName="";
		String errorDescription="";
		String errorPrice="";
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		String price1 = request.getParameter("price");
		String valor = request.getParameter("valor");

		log.debug("Ini nom "+nom);
		log.debug("Ini desc "+description);
		log.debug("Ini  price "+price1);		
		try
		{
			
			
			log.debug("valor "+valor);
			if (valor.equals("2"))
			{
				if (nom=="") errorName="camp Name NULL";
				if (description=="") errorDescription="camp Description NULL";
				if (price1=="") errorPrice="camp Price NULL";
				
				if (errorName.equals("") && errorDescription.equals("") && errorPrice.equals(""))
				{ 
					log.debug("3 camps informats");
					log.debug("nom "+nom);
					log.debug("desc "+description);
					log.debug("price "+price1);
					try
					{
						
						Double price  = Double.parseDouble(price1);
						Product p = new Product(id,nom,description,price);
						Session sessio = HibernateUtil.getSessionFactory().getCurrentSession();
					    final Transaction tx = sessio.beginTransaction();
					    sessio.save(p);
					    
						tx.commit();
						log.debug("commit");
						out.println(productList());	
						log.debug("lista");
						return;
					    
					} catch (Exception ex) {
						log.debug("exception");
						request.setAttribute("nom",nom);
						request.setAttribute("description",description);
						request.setAttribute("price",price1);				
						request.setAttribute("errorName",errorName);
						request.setAttribute("errorDescription",errorDescription);
						request.setAttribute("errorPrice",errorPrice);
						log.debug("redir...");
					    RequestDispatcher dispatcher = request.getRequestDispatcher("addProd");
					    dispatcher.forward(request, response);
		
					}
				}//if 	
		         else
		         {
		        	 	log.debug("else");
						request.setAttribute("nom",nom);
						request.setAttribute("description",description);
						request.setAttribute("price",price1);				
						request.setAttribute("valor",'2');
						valor="2";
						request.setAttribute("errorName",errorName);
						request.setAttribute("errorDescription",errorDescription);
						request.setAttribute("errorPrice",errorPrice);
					    RequestDispatcher dispatcher = request.getRequestDispatcher("addProd");
					    dispatcher.forward(request, response);
					    log.debug("else end");
		
		         }		
			
			}	
			else {
				log.debug("else2");
				RequestDispatcher dispatcher = request.getRequestDispatcher("addProd");
				dispatcher.forward(request, response);
				}
		}catch(java.lang.NullPointerException ex) {
			log.debug("exception.....");	
			out.println(ini());
				}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	private String productList()
	{
        return new ProductList().tableList();
	}	
}

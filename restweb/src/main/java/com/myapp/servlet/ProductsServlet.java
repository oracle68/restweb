package com.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.model.Product;
import com.myapp.util.HibernateUtil;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String tr="";
		 String message="<table border='1'><tr><td>Id</td><td>name</td><td>description</td><td>Price</td></tr>";
		 
 		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         final Transaction tx = session.beginTransaction();
		    Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("name","%",MatchMode.ANYWHERE));
			criteria.add(Restrictions.ge("price", 1.0));
			List<Product> pList = criteria.list();
			for (Product var: pList)
			{
				message+="<tr><td>"+var.getId()+"</td><td>"+var.getName()+"</td><td>"+var.getDescription()+"</td>";
				message+="<td>"+var.getId()+"</td></tr>";
			}		
		    tx.commit();
		    
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Hola</title>");
		    out.println("</head>");
		    out.println("<body bgcolor=\"white\">");
		    out.println(message);
		    out.println("</body>");
		    out.println("</html>");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

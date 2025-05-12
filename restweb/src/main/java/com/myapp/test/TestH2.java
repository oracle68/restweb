package com.myapp.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.transform.Transformers;

import com.myapp.model.Adresa;
import com.myapp.model.City;
import com.myapp.model.Product;
import com.myapp.model.Provincia;
import com.myapp.model.Usuario;
import com.myapp.util.HibernateUtil;
import com.myapp.util.HibernateUtilH2;

public class TestH2 {

    public TestH2() {
    	
    }
	
	public static void main (String[]  args) throws Exception
	{
		//exportdb();
		test();
		
	}
	
	private static void exportdb() throws Exception {
        String outputFile="src/main/java/createdb.sql";
        Configuration configuration = new Configuration();
        configuration.configure("hibernateh2.cfg.xml");
		  SchemaExport schema=new SchemaExport(configuration);
		  schema.setOutputFile(outputFile);
		  schema.setDelimiter(";");
		  schema.create(true,false);
	}	
	public static void test() throws  Exception
	{
		List <Usuario> us = new ArrayList<>(); 
		Long userId=1L;
		String firstName="Josh";
		String lastName="Josh";
		String gender="Male";
		String city ="Barcelona";
		String firstName2="Jane";
		String lastName2="Jane";
		String gender2="Female";
		String city2 ="Barcelona";
		String firstName3="Helena";
		String lastName3="Helena";
		String gender3="Female";
		String city3 ="Barcelona";		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = sdf1.parse("25/10/2019");        
		Long idadr =1L; 		
		
		Session session = HibernateUtilH2.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
	    City cityBean= new City(1L,"Barcelona");
	    City cityBean2= new City(2L,"Lleida");
	    City cityBean3= new City(3L,"Girona");	    
	    Adresa adr =  new Adresa(1L,"Carrer de Barcelona"); 
	    Adresa adr2 = new Adresa(12L,"Carrer de Lleida");
	    Adresa adr3 = new Adresa(12L,"Carrer de Girona");	    
	    session.save(adr2);
	    Provincia provincia = new Provincia ("08","Barcelona");
	    Provincia prov = new Provincia ("06","Lleida");	    
	    Provincia prov1 = new Provincia ("07","Girona");
	    Provincia prov2 = new Provincia ("09","Tarragona");
	  //  Usuario usu = new Usuario(userId, city,fecha, firstName,lastName,gender,cityBean, provincia,adr);
	  //  Usuario usu2 = new Usuario(userId, city2,fecha, firstName2,lastName2,gender2,cityBean2, prov,adr2);	    
	   // Usuario usu3 = new Usuario(userId, city3,fecha, firstName3,lastName3,gender3,cityBean3, prov2,adr3);	    
	    //us.add(usu);
	    if (cityBean!=null)
	    {	
	    	session.save(cityBean);
	    	session.save(cityBean2);
	    	session.save(cityBean3);
	    }	
	    if (adr!=null) {
	    	session.save(adr);
	    	session.save(adr2);
	    	session.save(adr3);
	    }
	    if (provincia!=null) 
	    {

		    session.saveOrUpdate(provincia);
		    session.saveOrUpdate(prov);
		    session.saveOrUpdate(prov1);
		    session.saveOrUpdate(prov2);
	    }
	    //session.save(usu);
	    //session.save(usu2);
	    //session.save(usu3);
	    Criteria crit = (Criteria) session.createCriteria(Usuario.class).
             setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);	
	            crit.add(Restrictions.isNotNull("adresa"));	    
     us = crit.list();
     
     System.out.println("Total filas= "+us.size());
     for (Usuario var:  us){
        System.out.println(var.toString());
     }

	    String sql = "select * from provincia";
	    SQLQuery query = session.createSQLQuery(sql);
	    query.setResultTransformer(Transformers.aliasToBean(Provincia.class));	    
	    query.addEntity(Provincia.class);
	    List <Provincia> pr = query.list();
	    System.out.println("Total provincias= "+pr.size());
	    for (Provincia var:  pr){
	           System.out.println(var.toString());
	        }
	    tx.commit();
	    
	    if (session.isOpen())
	    {
	    	System.out.println("Close session.");	
	    	session.close();
	    }	
	    
	}	

	public void save () throws Exception 
	{
		Session session = HibernateUtilH2.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();

		Long id=1L;
		String name;
		String description;
		Double price;
		for (int i=1;i<100;i++)
		{
			name="P"+i;
			description ="Desc "+i;
			price=200.0+i;
			Product p = new Product(id,name,description,price);
			session.save(p);
		}
	    String sql;
	    try 
        {
	    	BufferedReader buf = new BufferedReader(new FileReader("src/main/resources/insert_h2.sql"));
	    	while ((sql = buf.readLine()) != null) {     
	      	    SQLQuery query = session.createSQLQuery(sql);
	    	    query.setResultTransformer(Transformers.aliasToBean(Product.class));	    
	    	    query.addEntity(Product.class);
	    	    query.executeUpdate(); //Para las actualizaciones de datos;
	              
	          }	    	
        }catch (Exception ex) {ex.printStackTrace();}	
      
	    Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.like("name","%",MatchMode.ANYWHERE));
		criteria.add(Restrictions.ge("price", 10.0));
		List<Product> pList = criteria.list();
		for (Product var: pList)
		{
			System.out.println(var.toString());	
		}	
		
	    tx.commit();
	    if (session.isOpen())
	    {
	    	System.out.println("close session.....");	
	    	session.close();
	    }
	    //Call controller ProductList
	    /*ProductController pc = new ProductController();
	    ModelMap map = new ModelMap();
	    map.addAttribute("map",pList);
	    HttpServletResponse response = ?;
	    pc.manual(map, response);
	    */
			  
	}  
}

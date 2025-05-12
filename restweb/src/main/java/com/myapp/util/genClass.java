package com.myapp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class genClass {

	private static String dao="Factura";
	private static String daom="factura";
	private static String c1="nom";
	private static String c1Type="String";
	private static String c2="description";
	private static String c2Type="String";
	private static String c3="price";
	private static String c3Type="BigDecimal";
	private static String url="src/main/java/com/myapp";
	private static String pack="com.myapp.";
	private static String fromDao="from "+dao;
	private static String packdao=pack+"dao";
	private static String packentity=pack+"model";
	private static String packservice=pack+"service";
	private static String packcontroller=pack+"controller";
	private static String nameDao="name=\""+dao+"";
	private static String urlJsp="src/main/webapp/WEB-INF/views/";
	private static String urlTest = "src/test/java/com/myapp/test/";
	private static String packTest = "com.myapp.test";
	private static String ficheroTest = "Test"+dao+"2.java";
	private static String addAction = "insert"+dao;
	private static String editAction = "edit"+dao;
	
	public static void main(String[] args) throws IOException {
		/*createModel();
		createDao();
		createDaoImpl();
		createService();
		createServiceImpl();
		createController();
		createAngularJs();
		createTest();
		createAddJsp();
		*/
		createEditJsp();

	}
	private static void createEditJsp() throws IOException{
		File file = new File(urlJsp+"edit"+dao+".jsp");
		String texto ="<%@ taglib uri=\"http://www.springframework.org/tags/form\" prefix=\"form\"%>\n" + 
				"<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>\n" + 
				"<%@ taglib uri=\"http://www.springframework.org/tags\" prefix=\"spring\"%>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<title> Edit"+dao+"</title>\n" + 
				"<style>\n" + 
				"body {\n" + 
				"	font-size: 20px;\n" + 
				"	color: teal;\n" + 
				"	font-family: Calibri;\n" + 
				"}\n" + 
				"\n" + 
				"td {\n" + 
				"	font-size: 15px;\n" + 
				"	color: black;\n" + 
				"	width: 100px;\n" + 
				"	height: 22px;\n" + 
				"	text-align: center;\n" + 
				"}\n" + 
				"\n" + 
				".heading {\n" + 
				"	font-size: 18px;\n" + 
				"	color: white;\n" + 
				"	font: bold;\n" + 
				"	background-color: orange;\n" + 
				"	border: thick;\n" + 
				"}\n" + 
				"</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<center>\n" + 
				"		<br /> <br /> <br /> <b>Edit "+dao+" Details </b><br /> <br />\n" + 
				"		<div>\n" + 
				"			<c:url var=\"post_url\" value=\"/"+editAction+"\" />\n" + 
				"			<form:form method=\"post\" action=\"${post_url}\" modelAttribute=\""+daom+"\">\n" + 
				"				<table>\n" + 
				"					<tr>\n" + 
				"						<td>"+c1+"</td>\n" + 
				"						<td><form:input path=\""+c1+"\" required=\"required\"\n" + 
				"								value=\"${map."+daom+"."+c1+"}\" /></td>\n" + 
				"								<!--  oninvalid=\"setCustomValidity('Camp obligatori')\" -->\n" + 
				"					</tr>\n" + 
				"					<tr>\n" + 
				"						<td>"+c2+"</td>\n" + 
				"						<td><form:input path=\""+c2+"\" value=\"${map."+daom+"."+c2+"}\" />\n" + 
				"						</td>\n" + 
				"					</tr>\n" + 
				"					<tr>\n" + 
				"						<td>"+c3+"</td>\n" + 
				"						<td><form:input path=\""+c3+"\" value=\"${map."+daom+"."+c3+"}\" />\n" + 
				"					</tr>\n" + 
				"						<td>&nbsp;</td>\n" + 
				"						<td><input type=\"submit\" value=\"Save\" /></td>\n" + 
				"					</tr>\n" + 
				"				</table>\n" + 
				"\n" + 
				"				<form:hidden path=\"id\" value=\"${map."+daom+".id}\" />\n" + 
				"				\n" + 
				"			</form:form>\n" + 
				"		</div>\n" + 
				"	</center>\n" + 
				"</body>\n" + 
				"</html>";
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();			
	}
	
	private static void createAddJsp() throws IOException{
		File file = new File(urlJsp+"add"+dao+".jsp");
		String texto="<%@taglib uri=\"http://www.springframework.org/tags\" prefix=\"spring\"%>\n" + 
				"<%@taglib uri=\"http://www.springframework.org/tags/form\" prefix=\"form\"%>\n" + 
				"<%@taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<title>Register</title>\n" + 
				"<script src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>\n" + 
				"<style>\n" + 
				"body {\n" + 
				"	font-size: 20px;\n" + 
				"	color: teal;\n" + 
				"	font-family: Calibri;\n" + 
				"}\n" + 
				"\n" + 
				"td {\n" + 
				"	font-size: 15px;\n" + 
				"	color: black;\n" + 
				"	width: 100px;\n" + 
				"	height: 22px;\n" + 
				"	text-align: left;\n" + 
				"}\n" + 
				"\n" + 
				".heading {\n" + 
				"	font-size: 18px;\n" + 
				"	color: white;\n" + 
				"	font: bold;\n" + 
				"	background-color: orange;\n" + 
				"	border: thick;\n" + 
				"}\n" + 
				"</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"		<br /> <br /> <br /> <b> Registration Form </b> <br />\n" + 
				"		<br />\n" + 
				"		<div>\n" + 
				"		<c:url var=\"post_url\" value=\"/"+addAction+"\" />\n" + 
				"			<form:form method=\"post\" action=\"${post_url}\" modelAttribute=\""+dao+"\">\n" + 
				"				<table>\n" + 
				"					<tr>\n" + 
				"						<td>"+c1+"</td>\n" + 
				"						<td><form:input path=\""+c1+"\" required=\"required\"/></td><td><span id=\"mensaje\"></span></td>\n" + 
				"					</tr>\n" + 
				"					<tr>\n" + 
				"						<td>"+c2+"</td>\n" + 
				"						<td><form:input path=\""+c2+"\" /></td>\n" + 
				"					</tr>\n" + 
				"					<tr>\n" + 
				"						<td>"+c3+"</td>\n" + 
				"						<td><form:input path=\""+c3+"\" /></td>\n" + 
				"					</tr>\n" + 
				"						<td>&nbsp;</td>\n" + 
				"						<td><input type=\"submit\" value=\"Save\" /></td>\n" + 
				"					</tr>\n" + 
				"						<td colspan=\"2\"><a href=\"getList\">Click Here to See List</a></td>\n" + 
				"					</tr>\n" + 
				"				</table>\n" + 
				"			</form:form>\n" + 
				"		</div>\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>";
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();				
	}
	
	private static void createController() throws IOException{
		File file = new File(url+"/controller/"+dao+"Controller.java");
		String texto="package "+packcontroller+";\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Controller;\n" + 
				"import org.springframework.web.bind.annotation.RequestMapping;\n" + 
				"import org.springframework.web.bind.annotation.RequestMethod;\n" + 
				"import org.springframework.web.bind.annotation.ResponseBody;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"import "+packservice+"."+dao+"Service;\n" + 
				"\n" + 
				"@Controller\n" + 
				"public class "+dao+"Controller {\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"	private "+dao+"Service "+daom+"Service;      \n" + 
				"	@RequestMapping(value = \"/"+daom+"ListJson\", method = RequestMethod.GET, produces=\"application/json\")\n" + 
				"	public @ResponseBody List getAll"+dao+"() {\n" + 
				"		System.out.println(\"#########getAll()#########\");\n" + 
				"		List<"+dao+"> "+daom+"List = "+daom+"Service.findAll();\n" + 
				"		return "+daom+"List;\n" + 
				"	}\n" + 
				"	\n" + 
				"}";
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();				
	}
			
	
	private static void createModel() throws IOException{
		File file = new File(url+"/model/"+dao+".java");
		String texto = "package "+packentity+";\n" + 
				"\n" + 
				"import javax.persistence.Column;\n" + 
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.GenerationType;\n" + 
				"import javax.persistence.Id;\n" + 
				"import javax.persistence.Table;\n" + 
				"\n" + 
				"\n" + 
				"@Entity("+nameDao+"\")\n" + 
				"@Table("+nameDao+"\")\n" + 
				"\n" + 
				"public class "+dao +" {\n" + 
				"	@Id\n" + 
				"	@GeneratedValue(strategy = GenerationType.AUTO)\n" + 
				"	private Long id;\n" + 
				"	@Column(\"name=\""+c1+"\")\n" + 
				"	private "+c1Type+" "+c1+";\n" + 
				"	@Column(\"name=\""+c2+"\")\n" + 
				"	private "+c2Type+ " "+c2+";\n" + 
				"	@Column(\"name=\""+c3+"\")\n" + 
				"	private "+c3Type+ " "+c3+";\n"
				+ "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}
	
	private static void createService() throws IOException{


		File file = new File(url+"/service/"+dao+"Service.java");
		  
		String texto = "package "+pack+"service;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"\n" + 
				"public interface "+dao+"Service {\n" + 
				"\n" + 
				"	"+dao+" findById(long Id);\n" + 
				"\n" + 
				"	List<"+dao+"> findAll();\n" + 
				"\n" + 
				"	void add"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
				"	void delete"+dao+"(long Id);\n" + 
				"	\n" + 
				"	void update"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
			    "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}

	private static void createServiceImpl() throws IOException{
		File file = new File(url+"/service/"+dao+"ServiceImpl.java");
		String texto = "package "+pack+"service;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Service;\n" + 
				"import org.springframework.transaction.annotation.Transactional;\n" + 
				"import "+packdao+"."+dao+"Dao;\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"import "+packservice+"."+dao+"Service;\n" + 
				"\n" + 
				"@Service\n" + 
				"@Transactional\n" + 
				"public class "+dao+"ServiceImpl implements "+dao+"Service { \n" + 
				"\n" + 
				"	@Autowired\n" + 
				"	private "+dao+"Dao "+daom+"Dao;\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public "+dao+" findById(long Id) { \n" + 
				"\n" + 
				"		return "+daom+"Dao.findById(Id);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	\n" + 
				"	public List<"+dao+"> findAll() {\n" + 
				"		return "+daom+"Dao.findAll();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"\n" + 
				"	public void add"+dao+"("+dao+" "+daom+") {\n" + 
				"		"+daom+"Dao.add"+dao+"("+daom+");\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void delete"+dao+"(long Id) {\n" + 
				"		"+daom+"Dao.delete"+dao+"(Id);\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void update"+dao+"("+dao+" "+daom+") {\n" + 
				"		"+daom+"Dao.update"+dao+"("+daom+");\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"}\n"; 
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
		
	}
	
	private static void createDao() throws IOException{
		
		File file = new File(url+"/dao/"+dao+"Dao.java");
		  
		String texto = "package "+packdao+";\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"\n" + 
				"public interface "+dao+"Dao {\n" + 
				"\n" + 
				"	"+dao+" findById(long Id);\n" + 
				"\n" + 
				"	List<"+dao+"> findAll();\n" + 
				"\n" + 
				"	void add"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
				"	void delete"+dao+"(long Id);\n" + 
				"	\n" + 
				"	void update"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
			    "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}
	private static void createDaoImpl() throws IOException{
		
		
		File file = new File(url+"/dao/"+dao+"DaoImpl.java");
		  
		String texto = "package "+packdao+";\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.hibernate.SessionFactory;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Repository;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"\n" + 
				"@Repository\n" + 
				"public class "+dao+"DaoImpl implements "+dao+"Dao{\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"    private SessionFactory sessionFactory;\n" + 
				"\n" + 
				"@Override\n" + 
				"				public "+dao+" findById(long Id) {\n" + 
				"					"+dao+" "+daom+" = ("+dao+") sessionFactory.getCurrentSession().get("+dao+".class, Id);\n" + 
				"					return "+daom+";\n" + 
				"				}"+
				"\n" + 
				"	@Override\n" + 
				"	public List<"+dao+"> findAll() {\n" + 
				"		 return sessionFactory.getCurrentSession().createQuery(\""+fromDao+"\").list(); \n" +
				
				"	}\n" + 
				"	@Override\n" + 
				"	public void add"+dao+"("+dao+" "+daom+") {\n" + 
				"		sessionFactory.getCurrentSession().save("+daom+");\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void delete"+dao+"(long Id) {\n" + 
				"		"+dao+" "+daom+" = ("+dao+") sessionFactory.getCurrentSession().get("+dao+".class, Id); \n" + 
				"        if (null != "+daom+") {\n" + 
				"            sessionFactory.getCurrentSession().delete("+daom+");\n" + 
				"        }\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void update"+dao+"("+dao+" "+daom+") {\n" + 
				"		sessionFactory.getCurrentSession().update("+daom+");\n" + 
				"		\n" + 
				"	}"+
				"}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();
		
	}
	
	private static void createAngularJs() throws IOException {
		File file = new File(urlJsp+dao+"AngularJS.jsp");		
		String texto ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + 
				"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 
				"    pageEncoding=\"UTF-8\"%>\n" + 
				"<!DOCTYPE html><html><head>    <title>AngularJS"+ dao +"List</title>  \n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js\"></script>  \n" + 
				" </head>\n" + 
				"<body ng-app ng-controller=\"MyFilter\">\n" + 
				" AngularJS"+ dao +"List\n" + 
				"\n" + 
				"<table>\n" + 
				"<tr>\n" + 
				"  <td>id</td>\n" + 
				"  <td>nom</td>\n" + 
				"</tr>  \n" + 
				"<tr ng-repeat=\"elemento in lista track by $index\">\n" + 
				"   <td>{{elemento.id}}</td>\n" + 
				"  <td>{{elemento.nom}}</td> \n" + 
				"</tr>	\n" + 
				"</table>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				" <script> \n" + 
				"       function MyFilter($scope,$http)\n" + 
				"  {           \n" + 
				"     \n" + 
				"    	   $http.get('"+daom+"ListJson')\n" + 
				"   	    .success(function (response){\n" + 
				"   	        $scope.lista = response;\n" + 
				"   	        console.log($scope.lista);\n" + 
				"   	    })\n" + 
				"   	    .error(function (response){\n" + 
				"   	        	        console.log(response); \n" + 
				"   	  }); \n" + 
				"    \n" + 
				"	}\n" + 
				"  \n" + 
				"</script>\n" + 
				"</body>\n" + 
				"</html>";
		
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}

	private static void createTest() throws IOException {
		
		File file = new File (urlTest+packTest+ficheroTest);
		String texto = "package "+packTest+";\n"
				+ "import static org.junit.Assert.assertEquals;\n" + 
				"\n" + 
				"import org.junit.Before;\n" + 
				"import org.junit.Test;\n" + 
				"import org.junit.runner.RunWith;\n" + 
				"import org.mockito.MockitoAnnotations;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.test.context.ContextConfiguration;\n" + 
				"import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;\n" + 
				"import org.springframework.test.context.web.WebAppConfiguration;\n" + 
				"import org.springframework.test.web.servlet.MockMvc;\n" + 
				"import org.springframework.test.web.servlet.setup.MockMvcBuilders;\n" + 
				"\n" + 
				"import "+packservice+"."+dao+"Service;\n" + 
				"\n" + 
				"@RunWith(SpringJUnit4ClassRunner.class)\n" + 
				"@ContextConfiguration(locations = { \"classpath*:spring-servlet.xml\" })\n" + 
				"@WebAppConfiguration\n"+
				"public class Test"+dao+"2 {\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"    private "+dao+"Service"+" "+daom+"Service; \n" + 
				"\n" + 
				"	private MockMvc mockMvc; \n" + 
				"	\n" + 
				"	@Before\n" + 
				"    public void setUp(){\n" + 
				"    	  // Process mock annotations\n" + 
				"        MockitoAnnotations.initMocks(this);\n" + 
				"\n" + 
				"         //Setup Spring test in standalone mode\n" + 
				"        this.mockMvc = MockMvcBuilders.standaloneSetup("+daom+"Service).build();\n" + 
				"    }\n" + 
				"\n" + 
				"	@Test\n" + 
				"    public void test"+daom+"() {\n" + 
				"		  String nom = "+daom+"Service.getId(1).getNom();\n" + 
				"		  assertEquals(nom,\"BAR\");\n" + 
				"	}\n" + 
				"}";
		
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();			
	}	
}

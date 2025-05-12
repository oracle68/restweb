<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html> <!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd"-->
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>usuaris</title>
</head>
<script>
function sortTable() {
	  var table, rows, switching, i, x, y, shouldSwitch;
	  table = document.getElementById("myTable");
	  switching = true;
	  /* Make a loop that will continue until
	  no switching has been done: */

	  while (switching) {
	    // Start by saying: no switching is done:
	    switching = false;
	    rows = table.rows;
	    /* Loop through all table rows (except the
	    first, which contains table headers): */
	    for (i = 1; i < (rows.length - 1); i++) {
	      // Start by saying there should be no switching:
	      shouldSwitch = false;
	      /* Get the two elements you want to compare,
	      one from current row and one from the next: */
	      x = rows[i].getElementsByTagName("td")[0];
	      y = rows[i + 1].getElementsByTagName("td")[0];
	      // Check if the two rows should switch place:
	      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
	        // If so, mark as a switch and break the loop:
	        shouldSwitch = true;
	        break;
	      }
	    }
	    if (shouldSwitch) {
	      /* If a switch has been marked, make the switch
	      and mark that a switch has been done: */
	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	      switching = true;
	    }
	  }
	}
</script>
<body>
<sql:setDataSource var="DS" driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:@localhost:1521/xe"
     user="jose"  password="jose"/>


    <h1>Usuaris </h1>
    <form name="newxtecForm"
        action="InsUsers"
        method="POST">
        <table  border="0">
            <tr>
                <td>first_name:</td>
                <td><input type="text" name="first_name" /></td>
            </tr>
            <tr>
                <td> last_name:</td>
                <td><input type="text" name="last_name" /></td>
            </tr>
            <tr>
                <td>gender</td>
                <td><input type="text" name="gender" /></td>
            </tr>
            <tr>
                <td>Fecha</td>
                <td><input lang ="es" type="date" name="fecha" /> Format yyyy-mm-dd</td>
            </tr> 
            <tr>
                <td>Action</td>
                <td><INPUT TYPE="radio" name="accio" checked value="I"/>Insert
					<INPUT TYPE="radio" NAME="accio" VALUE="D"/>Delete
				</td>
            </tr>
            <tr>
                <td><input type="submit" value="Insert"/></td>
            </tr>
        </table>
        
    </form>
    <br/><br/>
   
    <c:catch var ="catchException">
     <c:choose>
       
     <c:when test="${not empty param.first_name
                                   && not empty param.last_name
                                   && not empty param.gender
                                   && not empty param.fecha
                                   }">      
    <fmt:parseDate value="${param.fecha}" var="parsedDatefecha" pattern="yyyy-MM-dd" />

       <c:set var="ac" value="${param.accio}"/>
 
          <!-- c:out value="${ac}" /-->
          <c:if  test="${ac=='I'}">    
           <sql:update dataSource="${DS}" var="newxtec">
            INSERT INTO usuarios
                           (first_name,last_name,gender,fecha) VALUES (?,?,?,?) 
            <sql:param value="${param.first_name}" />
            <sql:param value="${param.last_name}" />
            <sql:param value="${param.gender}" />
            <sql:dateParam value="${parsedDatefecha}" type="DATE"/>  
            </sql:update> 
           </c:if>
       

          
           <c:if  test="${ac=='D'}"> 
           
            <sql:update dataSource="${DS}" var="newxtec">
            DELETE FROM usuarios where first_name = ? 
            <sql:param value="${param.first_name}" />
            </sql:update> 
          </c:if>  
          
               
    </c:when>
    <c:otherwise>
        <font color="#cc0000">Omplir els camps obligatoris.</font>
    </c:otherwise>
    </c:choose>
  </c:catch>   
    <br/><br/>
  <c:choose> 
  <c:when test = "${catchException != null}">
     <p>Error: ${catchException} <br />
      ${catchException.message}
     </p> <!--There is an exception: ${catchException.message}-->
         
   </c:when> 
   <c:when test = "${catchException == null}"> 
    <sql:query dataSource="${DS}" var="xtec">
        SELECT user_id,first_name,last_name,gender,fecha from usuarios
    </sql:query>
    <input type="button" value="Sort" onClick="sortTable();"/>
    <table id="myTable" border="1">
        <tr><th>user_id</th><th>first_name</th><th>last_name</th><th>gender</th><th>fecha</th> </tr>
        <c:forEach var="row" items="${xtec.rows}">
            <tr>
                <td><c:out value="${row.user_id}" /></td>
                <td><c:out value="${row.first_name}" /></td>
                <td><c:out value="${row.last_name}" /></td>
                <td><c:out value="${row.gender}" /></td>
                <td><c:out value="${row.fecha}" /></td>
            </tr>
        </c:forEach>
    
    </table>  
   </c:when>
   </c:choose>      
   
   </body>
</html>
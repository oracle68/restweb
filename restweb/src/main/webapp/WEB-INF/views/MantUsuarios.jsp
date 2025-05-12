<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
    driver="oracle.jdbc.driver.OracleDriver"
    url="jdbc:oracle:thin:@localhost:1521:xe"
    user="jose"
    password="jose"/>
<html>
<body>
Tabla
<sql:query var = "user" >
Select user_id,first_name,last_name,gender,fecha from usuarios
</sql:query>

<table border=1>
<c:forEach var="row" items="${user.rows}">
<tr>
<td><c:out value="${row.user_id}"/></td>
<td><c:out value="${row.first_name}"/></td>
<td><c:out value="${row.last_name}"/></td>
<td><c:out value="${row.gender}"/></td>
<td><c:out value="${row.fecha}"/></td>
</tr>
</c:forEach>
</table>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>  
</head>
<body>

<form name="myForm" action="addProduct" method="post">
<label>Name</label> <input type="text" name="name" value="<c:out value="${name}"/>" /> <c:out value="${errorName}"/> <br>
<label>Description</label> <input type="text" name="description" value="<c:out value="${description}"/>"/>
<c:out value="${errorDescription}"/> <br>
<label>Price</label> <input type="text" name="price" value="<c:out value="${price}"/>" />
<c:out value="${errorPrice}"/> <br>
<input type="submit" name="submit" value="Register"/>
</form>
</body>
</html>
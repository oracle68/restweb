<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title> EditFactura</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
		<br /> <br /> <br /> <b>Edit Factura Details </b><br /> <br />
		<div>
			<c:url var="post_url" value="/editFactura" />
			<form:form method="post" action="${post_url}" modelAttribute="factura">
				<table>
					<tr>
						<td>nom</td>
						<td><form:input path="nom" required="required"
								value="${map.factura.nom}" /></td>
								<!--  oninvalid="setCustomValidity('Camp obligatori')" -->
					</tr>
					<tr>
						<td>description</td>
						<td><form:input path="description" value="${map.factura.description}" />
						</td>
					</tr>
					<tr>
						<td>price</td>
						<td><form:input path="price" value="${map.factura.price}" />
					</tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>

				<form:hidden path="id" value="${map.factura.id}" />
				
			</form:form>
		</div>

</body>
</html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Register</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
	text-align: left;
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

		<br /> <br /> <br /> <b> Registration Form </b> <br />
		<br />
		<div>
		<c:url var="post_url" value="/insert" />
			<form:form method="post" action="${post_url}" modelAttribute="Factura">
				<table>
					<tr>
						<td>nom</td>
						<td><form:input path="nom" required="required"/></td><td><span id="mensaje"></span></td>
					</tr>
					<tr>
						<td>description</td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td>price</td>
						<td><form:input path="price" /></td>
					</tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
						<td colspan="2"><a href="getList">Click Here to See List</a></td>
					</tr>
				</table>
			</form:form>
		</div>

</body>
</html>
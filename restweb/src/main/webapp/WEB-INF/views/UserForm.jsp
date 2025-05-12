<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
<title> Edit User</title>
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
.center {
  text-align:center
}

</style>
</head>
<body>
	<div class="center">
		<br /> <br /> <br /> <b>Titol </b><br /> <br />
	
			
			<html:form action="userForm.do">
			
				<table align=center>
				<CAPTION ALIGN=top>Edit User Det</CAPTION>  
				<tr><b>Edit User Details </b></tr>
				<tr> </tr>
                    <tr> <td colspan=2><bean:write name="userForm" property="error" filter="false"/></tr>
					<tr>
						<td>First Name </td>
						<td><html:text property="firstname"></html:text></td>
						<!-- td><html:errors property="firstname" /></td-->
					</tr>
					<tr>
						<td>Last Name </td>
						<td><html:text property="lastname"></html:text></td>
						
					
					</tr>
					<tr>
						<td>Gender </td>
						<td><html:text property="gender"></html:text></td>
						
					</tr>
					<tr>

						<td>City </td>
						<td><html:text property="city"></html:text></td>

					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><html:submit value="Submit" /></td>
					</tr>
				</table>
				<input type="hidden" name="valor" value="1" />

			</html:form>
	
	</div>
</body>
</html>
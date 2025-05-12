<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Success</title>
</head>
<body>
    <h1>Congratulations!</h1>

    <p>You have successfully logged in.</p>

<p>Your Firstname is: <bean:write name="userForm" property="firstname" />.</p>
<p>Your lastname is: <bean:write name="userForm" property="lastname" />.</p>
<p>Your city  is: <bean:write name="userForm" property="city" />.</p>
<p>Your gender is: <bean:write name="userForm" property="gender" />.</p>

</body>
</html>
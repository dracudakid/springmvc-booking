<%--
  Created by IntelliJ IDEA.
  User: Tan Dat
  Date: 08/12/2016
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <sf:form method="post" commandName="user">
        Username: <sf:input path="username" /> <sf:errors path="username" cssClass="error" />
        Password: <sf:password path="password" /><sf:errors path="password" cssClass="error"/>
        Full name: <sf:input path="fullname" /><sf:errors path="fullname" cssClass="error" />
        Email: <sf:input path="email" />
        Dob: <sf:input path="dob" /><sf:errors path="dob" cssClass="error" />
        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>

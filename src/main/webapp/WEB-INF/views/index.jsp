<%--
  Created by IntelliJ IDEA.
  User: Tan Dat
  Date: 06/12/2016
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>SimpleWebApp</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Welcome to SimpleWebApp</h1>
<a href="<c:url value="/users" />">Spittles</a> |
<a href="<c:url value="/users/register" />">Register</a>
</body>
</html>

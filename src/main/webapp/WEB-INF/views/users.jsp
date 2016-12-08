<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <c:forEach items="${userList}" var="user" >
        <li>Username: ${user.username}</li>
    </c:forEach>
</body>
</html>

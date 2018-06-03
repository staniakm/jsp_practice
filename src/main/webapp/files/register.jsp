<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 30.05.18
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarejestruj</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    Please enter your name <input type="text" name="uname"/><br>
    Please enter your login <input type="text" name="un"/><br>
    Please enter your password <input type="password" name="pw"/>
    <input type="hidden" value="true" name="reg">
    <input type="submit" value="submit">
</form>


</body>
</html>

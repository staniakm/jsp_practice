<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 25.05.18
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" name="loginForm" method="post">
    <label>Login:</label><input type="text" name="login" id="login">
    <br><label>Password:</label><input type="password" name="pass" id="pass">
    <input type="hidden" value="" name="reg">
    <br><button name="submit" type="submit">Zaloguj</button>
</form>
<a href="${pageContext.request.contextPath}/files/register.jsp">Zarejestruj</a>


</body>
</html>

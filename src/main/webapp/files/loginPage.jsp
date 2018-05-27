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
<form action="./login" name="loginForm" method="post">
    <label>Login:</label><input type="text" name="login" id="login">
    <br><label>Password:</label><input type="password" name="pass" id="pass">
    <br><button name="submit" type="submit">Zaloguj</button>
</form>


</body>
</html>

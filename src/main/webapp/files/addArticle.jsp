<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 02.06.18
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
<style>
    #articleContent{
        width: 90%;
    }
</style>
<head>
    <title>New Article</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/wiki/main/articles/new" method="post">
    <label>Title:</label> <input name="title" type="text" value="Set title"><br>
    <label>Article content</label><br>
    <textarea name="articleContent" id="articleContent" cols="30" rows="10">Enter content here</textarea>
<br>
    <button type="submit" value="Submit">Wyślij</button>
</form>

</body>
</html>

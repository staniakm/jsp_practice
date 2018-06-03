<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 25.05.18
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generator</title>
</head>
<body>
<form name="passGenerator" method="post" action= "./generator">
    <label>Length:</label>
    <select name="length">
        <option>5</option>
        <option>10</option>
        <option>15</option>
        <option>20</option>
    </select>
    <br><label>Include Symbols:</label> <input type="checkbox" name="incChars">
    <br><label>Include Numbers::</label> <input type="checkbox" name="incNums">
    <br><label>Include LowerCase Characters:</label> <input type="checkbox" name="incLower">
    <br><label>Include UpperCase Characters:</label> <input type="checkbox" name="incUpper">
    <br><label>Exclude Ambiguous Characters:</label> <input type="checkbox" name="excAmbi">
    <br><label>Exclude Similar Characters::</label> <input type="checkbox" name="excSimi">

    <br>
    <button type="submit" value="Submit">Wyślij</button>
</form>
<br>

<hr>
<p>Password:
<c:if test="${requestScope.pas != null}">
    <%=request.getAttribute("pas")%>
</c:if>
</p>
</body>
</html>

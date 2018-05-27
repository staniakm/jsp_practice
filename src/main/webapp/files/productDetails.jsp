<%@ page import="com.mariusz.shop.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 26.05.18
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<%Product prod = ((Product) session.getAttribute("product"));%>

<td>
    <form name="modelDetail2" method="POST" action="./addToCart">
        <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
            <strong>Product:</strong>: <%=prod.getName()%>
        </font>
        <input type="hidden" name="modelNo" value=<%=prod.getName()%>>
        <font face="Verdana, Arial, Helvetica, sans-serif">
            <p><font size="2">
                <strong>Description</strong>: <%=prod.getUrl()%>
            </font><input type="hidden" name="description" value=<%=prod.getUrl()%>></p>
            <p><font size="2">
                <strong>Quantity</strong>: <input type="text" size="2" value="1" name="quantity"></font></p>
            <p><font size="2"><strong>Price</strong>: <%=prod.getPrice()%><input type="hidden" name="price"
                                                                                 value=<%=prod.getPrice()%>></font></p>
            <img src=<%=prod.getImgUrl()%> width="200" height="200">
            <hr>
            <input type="hidden" name="action" value="add">
            <input type="submit" name="addToCart" value="Add To Cart">
        </font></form>
</td>
</body>
</html>

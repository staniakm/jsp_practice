<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Shopping Cart</title>
</head>

<body>
<p><font face="Verdana, Arial, Helvetica, sans-serif"><strong>Shopping Cart details</strong></font></p>
<p><a href="./showAllProducts">Product list</a> </p>
<table width="75%" border="1">
    <tr bgcolor="#CCCCCC">
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product</font></strong></td>
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity</font></strong></td>
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Unit Price</font></strong></td>
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total</font></strong></td>
    </tr>

    <jsp:useBean id="cart" scope="session" class="com.mariusz.shop.entity.Cart" />
    <c:if test="${cart.totalItems==0}">
        <tr>
            <td colspan="4">- Cart is currently empty -<br/>
        </tr>
    </c:if>
    <c:forEach var="cartItem" items="${cart.items}" varStatus="counter">
        <%--<form name="item" method="POST" action="./CartControler">--%>
        <form name="item" method="POST" action="./placeOrder">
            <tr>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><b>
                    <c:out value="${cartItem.product.name}"/></b><br/>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                <input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'>
                <input type='text' name="quantity" value='<c:out value="${cartItem.quantity}"/>' size='2'>
                    <%--<input type="submit" name="action" value="Update" disabled>--%>
                    <%--<input type="submit" name="action" value="Delete" disabled></font></td>--%>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><c:out value="${cartItem.product.price}"/> zł</font></td>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><c:out value="${cartItem.totalCost}"/> zł</font></td>
            </tr>

    </c:forEach>
    <tr>
        <td colspan="2"> </td>
        <td> </td>
        <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Subtotal: <c:out value="${cart.totalCost}" /> zł</font></td>
    </tr>
    <tr>
        <td colspan="2"> </td>
        <td> </td>
        <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
            <input type="submit" name="addToCart" value="Place order">
        </font></td>
    </tr>
        </form>
</table>
</body>
</html>
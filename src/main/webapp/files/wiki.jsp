<%@ page import="com.mariusz.wiki.entities.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mariusz.wiki.entities.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/files/styles.css" type="text/css"/>

    <title>Wiki page</title>
</head>
<body>

<div class="container">
    <div class="item header" style="text-align: center"><h1>Wiki main page.</h1></div>
    <div class="item nav">

        <div class="sidenav">
            <c:if test="${!empty sessionScope.userAuth}">
                <a href="${pageContext.request.contextPath}/wiki/main/articles/new">New Article</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/wiki/main/articles">Articles</a>
            <a href="${pageContext.request.contextPath}/wiki/main">Main</a>
            <hr>
            <c:if test="${empty sessionScope.userAuth}">
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </c:if>
            <c:if test="${!empty sessionScope.userAuth}">
                <a href="${pageContext.request.contextPath}/logout">Logout <%=((Person)session.getAttribute("userAuth")).getName()%></a>
            </c:if>

            <a href="${pageContext.request.contextPath}/files/register.jsp">Register</a>
            <%--<a href="#services">Services</a>--%>
            <%--<a href="#clients">Clients</a>--%>
            <%--<a href="#contact">Contact</a>--%>
        </div>
    </div>
    <div class="item content">
        <c:forEach items="${articles}" var="list">
            <div class="col-md-10 blogShort">
                <div id="containerIntro">
                    <h2>
                        <c:choose>
                            <c:when test="${!empty sessionScope.userAuth}">
                                <a class="btn btn-sm btn-blog pull-right marginBottom10"
                                   href="${pageContext.request.contextPath}/wiki/main/articles/article?id=${list.getId()}"
                                   role="button"><c:out value="${list.getTitle()}"/></a>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${list.getTitle()}"/>
                            </c:otherwise>
                        </c:choose>
                    </h2>
                </div>
                <p class="author">(<c:out value="${list.getAuthor()}"/> - <c:out value="${list.getUpdateDate()}"/>)</p>
                <article><p>
                    <c:out value="${list.getContent().getShortContent()}"/>
                </p></article>

            </div>
            <%--<tr>--%>
            <%--<a href="../wiki/main/articles/article?id=${list.getId()}"><c:out value="${list.getTitle()}"/>--%>
            <%--( <c:out value="${list.getAuthor()}"/> - <c:out value="${list.getUpdateDate()}"/>)</a><br>--%>
            <%--</tr>--%>
        </c:forEach>
    </div>
    <div class="item footer">
        <c:out value="${sessionScope.userAuth}"/>
    </div>
</div>

<%--<h1>Wiki main page.</h1>--%>

<%--<p><a href="${pageContext.request.contextPath}/login">Login</a>--%>
<%--<a href="${pageContext.request.contextPath}/files/register.jsp">Register</a>--%>
<%--</p>--%>
<%--<hr>--%>
<%--<h3><a href="../wiki/main/articles/new">New Article</a>--%>
<%--<a href="../wiki/main/articles">Articles</a></h3>--%>
<%--<hr>--%>
<%--<h4>Top 5 newest articles</h4>--%>
<%--<c:forEach items="${articles}" var="list">--%>
<%--<div class="col-md-10 blogShort">--%>
<%--<div id="containerIntro"><h2>  <a class="btn btn-sm btn-blog pull-right marginBottom10" href="${pageContext.request.contextPath}/wiki/main/articles/article?id=${list.getId()}" role="button"><c:out value="${list.getTitle()}"/></a></h2></div>--%>
<%--<p class="author">(<c:out value="${list.getAuthor()}"/> - <c:out value="${list.getUpdateDate()}"/>)</p>--%>
<%--<article><p>--%>
<%--<c:out value="${list.getContent().getShortContent()}"/>--%>
<%--</p></article>--%>

<%--</div>--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="../wiki/main/articles/article?id=${list.getId()}"><c:out value="${list.getTitle()}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;( <c:out value="${list.getAuthor()}"/> - <c:out value="${list.getUpdateDate()}"/>)</a><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--</c:forEach>--%>
</body>
</html>

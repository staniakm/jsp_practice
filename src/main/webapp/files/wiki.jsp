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
                <a href="${pageContext.request.contextPath}/logout">Logout <%=((Person) session.getAttribute("userAuth")).getName()%>
                </a>
            </c:if>

            <a href="${pageContext.request.contextPath}/files/register.jsp">Register</a>
        </div>
    </div>
    <div class="item content">
        <c:forEach items="${articles}" var="list">
            <div class="col-md-10 blogShort">
                <div id="containerIntro">
                    <h2 class="artTitle">
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
        </c:forEach>
    </div>
    <div class="item footer">
        <c:out value="${sessionScope.userAuth}"/>
    </div>
</div>
</body>
</html>

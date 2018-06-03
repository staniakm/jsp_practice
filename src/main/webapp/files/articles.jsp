<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/files/styles.css" type="text/css"/>
    <style>
        #containerIntro h2 {
            display: inline;
            vertical-align: top;
            font-family: 'Open Sans', sans-serif;
            line-height: 28px;
        }

        #containerIntro p {
            display: inline;
            vertical-align: top;
            font-family: 'Open Sans', sans-serif;
            font-size: 16px;
            line-height: 28px;
        }

        .nav {
            height: 87vh;
        }
    </style>
    <title>Articles</title>
</head>
<body>

<div class="container">
    <div class="item header" style="text-align: center"><h2>Articles list</h2></div>
    <div class="item nav">
        <div class="sidenav">
            <%--<a href="${pageContext.request.contextPath}/wiki/main/articles">Articles</a>--%>
            <a href="${pageContext.request.contextPath}/wiki/main">Main</a>
            <c:if test="${!empty sessionScope.userAuth}">
                <a href="${pageContext.request.contextPath}/wiki/main/articles/new">New Article</a>
            </c:if>
        </div>
    </div>

    <div class="item content">
        <c:forEach items="${articles}" var="list">
            <div class="col-md-10 blogShort">
                <div id="containerIntro"><h2 class="artTitle"><c:out value="${list.getTitle()}"/></h2>
                    <c:if test="${!empty sessionScope.userAuth}">
                        <a class="btn btn-sm btn-blog pull-right marginBottom10"
                           href="${pageContext.request.contextPath}/wiki/main/articles/article?id=${list.getId()}"
                           role="button">READ MORE</a>
                    </c:if>
                </div>
                <p class="author">(<c:out value="${list.getAuthor()}"/> - <c:out value="${list.getUpdateDate()}"/>)</p>
                <article><p>
                    <c:out value="${list.getContent().getShortContent()}"/>
                </p></article>

            </div>
        </c:forEach>

        <div class="col-md-12 gap10"></div>
    </div>

</div>
</body>
</html>

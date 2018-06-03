<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 01.06.18
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <%--<link rel="stylesheet" type="text/css" href="styles.css">--%>
    <%--<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>--%>
    <%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        h6 {
            margin: 10px 0px 15px 0px;
            font-size: 10px;
        }
        .sidenav {
            height: 100%;
            width: 160px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .sidenav a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .main {
            margin-left: 160px; /* Same as the width of the sidenav */
            font-size: 18px; /* Increased text to enable scrolling */
            padding: 20px 10px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
        #containerIntro h1
        {
            display: inline;
            vertical-align: top;
            font-family: 'Open Sans', sans-serif;
            /*font-size: 30px;*/
            line-height: 28px;
        }
        #containerIntro p {
            display: inline;
            vertical-align: top;
            font-family: 'Open Sans', sans-serif;
            font-size: 16px;
            line-height: 28px;
        }
    </style>
    <title>Articles</title>
</head>
<body>
<%--<h1>Articles</h1>--%>
<%--<hr>--%>
<%--<p><a href="${pageContext.request.contextPath}/wiki/main">Go to main</a> </p>--%>
<%--<hr>--%>

<div class="sidenav">

    <a href="${pageContext.request.contextPath}/wiki/main/articles">Articles</a>
    <a href="${pageContext.request.contextPath}/wiki/main">Main</a>
    <c:if test="${!empty sessionScope.userAuth}">
        <a href="${pageContext.request.contextPath}/wiki/main/articles/new">New Article</a>
    </c:if>
<%--<a href="#services">Services</a>--%>
    <%--<a href="#clients">Clients</a>--%>
    <%--<a href="#contact">Contact</a>--%>
</div>
<div class="main">
<c:forEach items="${articles}" var="list">
        <div class="col-md-10 blogShort">
           <div id="containerIntro"><h1><c:out value="${list.getTitle()}"/></h1>
               <c:if test="${!empty sessionScope.userAuth}">
               <a class="btn btn-sm btn-blog pull-right marginBottom10" href="${pageContext.request.contextPath}/wiki/main/articles/article?id=${list.getId()}" role="button">READ MORE</a>
               </c:if>
           </div>
            <h6>(<c:out value="${list.getAuthor()}"/> - <c:out value="${list.getUpdateDate()}"/>)</h6>
            <article><p>
                <c:out value="${list.getContent().getShortContent()}"/>
            </p></article>

        </div>
</c:forEach>

        <div class="col-md-12 gap10"></div>
</div>


</body>
</html>

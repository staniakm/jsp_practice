<%@ page import="com.mariusz.wiki.entities.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .content{
        text-align: justify;
    }
</style>
<head>
    <title>Article</title>
</head>
<body>
<%Article art = ((Article)request.getAttribute("art"));%>
<h5>by <%=art.getAuthor()%></h5>
<H1><%=art.getTitle()%></H1>

<div class="content"><%=art.getContent().getContent()%></div>


</body>

</html>

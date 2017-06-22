<%--
  Created by IntelliJ IDEA.
  User: Zhan
  Date: 2017/6/12 0012
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/common.jsp"/>
<html>
<head>
    <title>查看文章页面</title>
</head>
<body>
<div id="viewBlog">
    文章ID：{{blog.id}}<br>
    标题：{{blog.title}}<br>
    发布时间：{{blog.pubTime}}<br>
    内容：{{blog.content}}<br>
</div>
<a href="index.jsp">首页</a>
<script src="script/viewBlog.js?_v=0.2" type="text/javascript"></script>
</body>
</html>

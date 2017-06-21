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
    <title>管理员页面</title>
</head>
<body>

<div>
    <form action="/blog?action=post" method="post">
        标题：<input type="text" name="title"><br>
        时间：<input type="datetime" name="pubTime"><br>
        内容：<input type="text" name="content" height="20px"><br>
        <input type="submit" value="发布">
    </form>
</div>
</body>
</html>

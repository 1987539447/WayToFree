<%--
  Created by IntelliJ IDEA.
  User: Zhan
  Date: 2017/6/13 0013
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息页面</title>
</head>
<body>
<%=request.getSession().getAttribute("message")%>
<br>
<a href="index.jsp">首页</a>
</body>
</html>

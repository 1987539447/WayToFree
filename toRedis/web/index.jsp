<%--
  Created by IntelliJ IDEA.
  User: Zhan
  Date: 2017/6/12 0012
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>索引页</title>
</head>
<body>
    <table border="1">
        <thead>
            <td>功能</td>
            <td>说明</td>
        </thead>
        <tr>
            <td>管理员</td>
            <td><a href="/admin.jsp">查看设置管理员</a></td>
        </tr>
        <tr>
            <td>发布文章</td>
            <td><a href="/addPost.jsp">发布新文章</a></td>
        </tr>
        <tr>
            <td>查看文章</td>
            <td><a href="/viewBlog.jsp">查看指定文章</a></td>
        </tr>
    </table>
</body>
</html>

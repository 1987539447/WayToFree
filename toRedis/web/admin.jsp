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
    <title>发布文章页面</title>
</head>
<body>
<div id="blogAdmin">
    <p v-if="seted">欢迎管理员{{admin}}</p>
    <p v-else>请设置管理员：</p>
    管理员名称:<input v-model="admin">
    <button v-on:click="saveAdmin">设置</button>
</div>
<a href="index.jsp">首页</a>
<script src="script/admin.js?_v=0.4" type="text/javascript"></script>
</body>
</html>

<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%--guest标签，没有验证身份且么有rememberd--%>
<shiro:guest>Hi there,Please <a href="login.jsp">Login</a> Or <a href="signup">SignUp</a></shiro:guest>

<%--user标签，与guest相反，已经验证身份或remember--%>
<shiro:user>Welcome back Jhone ! Not Jhon ?Click <a href="login.jsp">Here</a> to login</shiro:user>

<%--authenticated标签,比user更严格，必须通过验证，与notauthenticate相反--%>
<shiro:authenticated><a href="update.jsp">Update your contact information</a></shiro:authenticated>
<%--notAuthenticated,没有通过验证--%>
<shiro:notAuthenticated>Please <a>Login</a> to update your credit card information </shiro:notAuthenticated>
<%--principal标签 默认使用principal.toStirng--%>
Hello <shiro:principal/>,how are you today?
<%--通过type获取属性--%>
User ID:<shiro:principal type="java.lang.Integer"/>
<%--获取复杂对象属性--%>
Hello <shiro:principal type="com.foo.User" property="firstName"/>, how are you today?
<%--hasRole标签 subject分配了某个具体角色--%>
<shiro:hasRole name="admin">
    <a href="admin.jsp">Administer the system</a>
</shiro:hasRole>
<%--lacksRole标签 subject未分配某个角色--%>
<shiro:lacksRole name="admin">
    Sorry, you are not allowed to administer the system
</shiro:lacksRole>
<%--hasAnyRole标签 subject分配了列表中任意一个角色--%>
<shiro:hasAnyRoles name="devloper,mananger">
    Do develop.
</shiro:hasAnyRoles>
<%--hasPermission标签 subject具有特定的权限 与lacksPermission相反--%>
<shiro:hasPermission name="user:create">
    <a href="creat.jsp">Create a new user</a>
</shiro:hasPermission>
lacksPermission 标签
<shiro:lacksPermission name="uesr:create">
    Sorry
</shiro:lacksPermission>
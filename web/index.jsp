<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<jsp:include page="islogin.jsp"></jsp:include>
<style type="text/css">
    .main {
        width: 600px
    }

    .right {
        width: 2000px;
        float: right;
        text-align: right;
        line-height: 10px
    }
</style>
<div class="right">当前用户:${userid }
    <a href="ExitLoginServlet">退出登录</a>
</div>
<br>
<body>
<h1 align="center">全部用户数据表</h1>
<form action="SelectUserBynameServlet" method="post" align="center">
    用户名:<input type="text" name="username">
    <input type="submit" value="查询该用户">
    <a href="${pageContext.request.contextPath }/AllUserServlet">显示全部用户</a>
    <a href="insert.jsp">插入一个用户</a>
</form>

<%--     <c:forEach items="${allUser }" var="user">
    	<tr>
    		<td>${user.id }</td>
    		<td>${user.usernmae }</td>
    		<td>${user.birthday }</td>
    		<td><a href="${pageContext.request.contextPath }/DeleteUserServlet?id=${user.id}">删除</a></td>
    	</tr>
    </c:forEach> --%>
<div class="row margin-top-20">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
        <tr align="center">
            <th class="seq" width="15%" height="35" align="center" scope="row">用户ID</th>
            <th width="15%" height="35" align="center" scope="row">用户名</th>
            <th width="22%" height="35" align="center" scope="row">密码</th>
            <th width="22%" height="35" align="center" scope="row">注册时间</th>
            <th width="40%" height="35" align="center" scope="row">用户管理操作</th>
        </tr>
        <c:forEach items="${allUser }" var="user">
            <tr align="center">
                <th>${user.id }</th>
                <th>${user.username }</th>
                <th>${user.password }</th>
                <th>${user.birthday }</th>
                <th><a href="${pageContext.request.contextPath }/DeleteUserServlet?id=${user.id}">删除</a>
                    <a href="${pageContext.request.contextPath }/OneUserServlet?id=${user.id}">修改</a>
                </th>
            </tr>
        </c:forEach><%request.removeAttribute("allUser"); %>
    </table>
</div>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'insert.jsp' starting page</title>

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
    <a href="AllUserServlet">返回主页</a>
    <a href="ExitLoginServlet">退出登录</a>
</div>
<br>
<body>
<h1 align="center">用户数据插入</h1>
<form action="InsertUserServlet" method="post">
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
        <tr align="center">
            <th class="seq" width="15%" height="35" align="center" scope="row">用户id</th>
            <th width="15%" height="35" align="center" scope="row">用户名</th>
            <th width="22%" height="35" align="center" scope="row">密码</th>
            <th width="22%" height="35" align="center" scope="row">注册时间</th>
            <th width="22%" height="35" align="center" scope="row">操作</th>
        </tr>
        <tr align="center">
            <th>自动生成</th>
            <th><input type="text" name="username"></th>
            <th><input type="text" name="password"></th>
            <th><input type="text" name="birthday"></th>
            <td><input type="submit" value="插入该用户"></td>
        </tr>
    </table>
</form>
</body>
</html>

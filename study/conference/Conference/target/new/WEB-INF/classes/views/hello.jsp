<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <body>
        <h2>Hello ssm!!!!</h2>
        <h2>${name} !!!</h2>
    </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <body>
        <form action="fileUpload" method="post" enctype="multipart/form-data">
            <p>选择文件：<input type="file" name="file" /></p>
            <p><input type="submit" value="提交"/></p>
        </form>

    </body>
</html>

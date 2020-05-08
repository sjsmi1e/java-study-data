<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/1 0001
  Time: 上午 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="/user/self_info/update" method="post">
            用户ID：<input type="text" name="user_id"/><br/>
            用户名：<input type="text" name="user_name"/><br/>
            用户年龄：<input type="text" name="user_age"/><br/>
            用户性别：<input type="text" name="user_sex"/><br/>
            用户描述：<input type="text" name="user_desc"/><br/>
            <input type="submit" value="提交"/>
        </form>

        <img src="/imgs/conf_portrait?conf_id=38"/>
    </body>
</html>
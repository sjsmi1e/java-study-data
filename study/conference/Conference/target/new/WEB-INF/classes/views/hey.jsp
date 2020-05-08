<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <body>
        <h2>HEY ssm!!!!</h2>
        <c:forEach items="${user}" var="u">
        <h2>${u.userId} &nbsp; ${u.username} </h2>
        </c:forEach>
    </body>
</html>

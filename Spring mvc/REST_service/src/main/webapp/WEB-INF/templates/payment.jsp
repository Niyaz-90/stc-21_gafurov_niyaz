<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 09.06.2021
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Enter info and pay!</title>
</head>
<body>
<!--/*@thymesVar id="user" type="ru.inno.entity.User"*/-->
<form action="#" th:action="@{/payment}" th:object="${user}">
    <input th:field="*{username}" id="username"/>
    <input th:field="*{password}" id="password"/>
    <input type="submit" value="Pay!">
</form>

</body>
</html>

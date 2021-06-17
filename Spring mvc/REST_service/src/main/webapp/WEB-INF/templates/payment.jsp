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
<!--/*@thymesVar id="userCard" type="ru.inno.entity.Card"*/-->
<form action="#" th:action="@{/payment}" th:object="${userCard}">
    <input th:field="*{cvv}" id="cvv"/>
    <input th:field="*{cardNumber}" id="number"/>
    <input th:field="*{validThru}" id="validThru"/>
    <input th:field="*{owner}" id="owner"/>
    <input type="submit" value="Pay!">
</form>

</body>
</html>

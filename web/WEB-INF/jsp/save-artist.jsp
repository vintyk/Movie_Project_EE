<%--
  Created by IntelliJ IDEA.
  User: Vinty
  Date: 14.04.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test03" method="post">
    <label for="name">ID исполнителя: </label>
    Артист: <input type="text" name="name" id="name" size="14"><br>
</form>
</body>
</html>

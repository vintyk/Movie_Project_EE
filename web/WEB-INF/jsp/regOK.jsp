<%@ page import="video.dao.UsersDao" %>
<%@ page import="video.Entity.Users" %>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration Ok!</title>

</head>
<body>
<%@ include file="header.jsp" %>
<br>
<h1>Вы успешно зарегистрировались!</h1>
<%@ include file="content.jsp" %>
User:  <%= UsersDao.getInstance().getById(1)%><br>
Зарегистрирован.
<a href="htmlCode/login.html">Войти в систему</a>
<%@ include file="footer.jsp" %>
</body>
</html>
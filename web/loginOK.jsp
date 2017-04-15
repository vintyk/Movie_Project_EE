<%@ page import="video.dao.UsersDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login Ok!</title>
</head>
<body>
<br>
<h1>Вы успешно вошли в систему!</h1>

Email: <%= UsersDao.getInstance().getById(1)%><br>

</body>
</html>
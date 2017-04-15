<%--
  Created by IntelliJ IDEA.
  User: Vinty
  Date: 15.04.2017
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<h1>Вход в систему</h1>
<form action="Registration" method="post">
    <label for="user">E-Mail</label>
    <input type="text" name="user" id="user"><br>
    <label for="pass">Пароль</label>
    <input type="password" name="password" id="pass"><br>
    <table>
        <th><small>
            <input type="submit" name="htmlCode/login.html" value="Войти в систему">
        </small>
        <th><small>
            <input type="submit" name="htmlCode/registration.html" value="Зарегистрироваться">
        </small>
    </table>
</form>
<br>
</body>
</html>

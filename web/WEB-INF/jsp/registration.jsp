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
<h1>Регистрация пользователя</h1>
<form action="AddUser" method="post">

    Email: <input type="text" name="email"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    Имя: <input type="text" name="user" size="10"><br>
    Фамилия: <input type="text" name="user" size="10"><br>
    Отчество: <input type="text" name="user" size="10"><br>
    <table>
        <th>
                <input type="submit" name="save" value="Зарегистрировать">
        </th>
    </table>
</form>
</body>
</html>

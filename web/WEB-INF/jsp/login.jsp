<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<!-- Не работает вставка картинки -->
<!-- <img  src="${pageContext.servletContext.contextPath}/login.png" border="0"  alt="login" > -->
<br>
<div class="col-md-4 bs-col"> <br>
<h1>Вход в систему</h1>
<form class="form-inline">
    <input type="text" class="input-small" placeholder="Email">
    <input type="password" class="input-small" placeholder="Password"><br>
    <label class="checkbox">
        <input type="checkbox"> Запомнить
    </label>
    <br>
    <button type="submit" class="btn">Отправить</button>
</form>
<!--
<form action="Registration" method="post">
    <label for="user">E-Mail</label>
    <input type="text" name="user" id="user"><br>
    <label for="pass">Пароль</label>
    <input type="password" name="password" id="pass"><br>

           <input type="submit" name="login" value="Войти в систему">
           <input type="submit" name="registration" value="Зарегистрироваться">
</form>
-->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"> Зарегистрироваться </button>
<select>
    <option>Русский</option>
    <option>English</option>
</select>
</div>
</body>
</html>

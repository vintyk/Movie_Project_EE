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
    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/login">
        <div class="control-group">
            <label class="control-label" for="inputEmail">Введите логин (E-Mail)</label>
            <div class="controls">
                <input type="text" id="inputEmail" name="inputEmail" placeholder="E-mail">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputPassword">Введите ваш пароль</label>
            <div class="controls">
                <input type="password" id="inputPassword" name="inputPassword" placeholder="Password">
            </div>
        </div>
        <label class="checkbox">
            <input type="checkbox"> Запомнить
        </label>
        <br>
        <select>
            <option>Русский</option>
            <option>English</option>
        </select>
        <br>
        <br>
        <button class="btn btn-primary btn-lg" data-toggle="modal" > Войти в систему </button>
    </form>
    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/registration">
        <br>
        <button class="btn btn-primary btn-lg" data-toggle="modal"> Зарегистрироваться </button>
    </form>


</div>
</body>
</html>

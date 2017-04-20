<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Admin Tool</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid bs-cont">
<div class="col-md-6 bs-col"> <br>
    <h1>Регистрация пользователя. Администратор.</h1>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/save">
        <div class="control-group">
            <label class="control-label" for="inputEmail">Введите логин</label>
            <div class="controls">
                <input type="text" id="inputEmail" placeholder="E-mail">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputPassword">Введите ваш пароль</label>
            <div class="controls">
                <input type="password" id="inputPassword" placeholder="Password">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputName">Введите имя</label>
            <div class="controls">
                <input type="text" id="inputName" placeholder="Имя">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputFamily">Фамилия</label>
            <div class="controls">
                <input type="text" id="inputFamily" placeholder="Фамилия">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputSname">Отчество (если есть)</label>
            <div class="controls">
                <input type="text" id="inputSname" placeholder="Отчество">
            </div>
            <br>
        </div>
        <label class="radio">
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
            Простой пользователь системы.
        </label>
        <label class="radio">
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
            Администратор.
        </label>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary btn-lg" > Зарегистрироваться </button>
            </div>
        </div>
    </form>
    <br>
</div>
</div>
</body>
</html>

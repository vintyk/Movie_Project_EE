<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRATION</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="col-md-4 bs-col"> <br>
    <h1>Регистрация пользователя</h1>
    <form class="form-horizontal" method="post">
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
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary btn-lg" > Зарегистрироваться </button>
            </div>
        </div>
    </form>

</div>
</body>
</html>

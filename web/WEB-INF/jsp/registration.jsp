<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>REGISTRATION</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="col-md-4 bs-col"> <br>
    <h1>Регистрация пользователя</h1>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/addUser">
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
        <div class="control-group">
            <label class="control-label" for="inputName">Введите имя</label>
            <div class="controls">
                <input type="text" id="inputName" name="inputName" placeholder="Имя">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputFamily">Фамилия</label>
            <div class="controls">
                <input type="text" id="inputFamily" name="inputFamily" placeholder="Фамилия">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputSname">Отчество (если есть)</label>
            <div class="controls">
                <input type="text" id="inputSname" name="inputSname" placeholder="Отчество">
            </div>
            <br>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary btn-lg" > Зарегистрироваться </button>
            </div>
        </div>
    </form>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/login">
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-primary btn-lg" > Войти в систему </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

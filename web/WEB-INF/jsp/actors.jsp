<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actors</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-pills navbar navbar-default navbar-fixed-top">
    <div class="container"></div>
    <li method="post" action="${pageContext.request.contextPath}/moviesProject"><A href="${pageContext.request.contextPath}/moviesProject"  title="Фильмы"> ФИЛЬМЫ </A></li>
    <li class="active" method="post" action="${pageContext.request.contextPath}/actors"><A href="${pageContext.request.contextPath}/actors"  title="Актеры"> АКТЕРЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/reviews"><A href="${pageContext.request.contextPath}/reviews"  title="Отзывы"> ОТЗЫВЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/users"><A href="${pageContext.request.contextPath}/users"  title="Отзывы"> ПОЛЬЗОВАТЕЛИ </A></li>
    </div>
</ul>
<br>
<div class="container-fluid bs-cont">
    <div class="col-md-6 bs-col"> <br>
        <h1>Aктеры</h1>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/actors">
            <button type="submit" class="btn btn-primary btn-lg" > Все актеры </button>
        </form>
        <br>

<h1>Добавить актера</h1>
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/actors">

    <div class="control-group">
        <label class="control-label" for="inputName">Введите имя актера</label>
        <div class="controls">
            <input type="text" id="inputName" placeholder="Имя">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFamily">Введите фамилию актера</label>
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
        <label class="control-label" for="inputDate">Дата рождения</label>
        <div class="controls">
            <input type="text" id="inputDate" placeholder="01.01.1950">
        </div>
        <br>
    </div>
    <label class="radio">
        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
        Актер.
    </label>
    <label class="radio">
        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
        Режисер.
    </label>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-primary btn-lg" > Сохранить актера в базе </button>
        </div>
    </div>
</form>
<br>
<br>
    </div>
</div>
</body>
</html>

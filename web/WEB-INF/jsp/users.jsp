<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-pills navbar navbar-default navbar-fixed-top">
    <div class="container"></div>
    <li method="post" action="${pageContext.request.contextPath}/moviesProject"><A href="${pageContext.request.contextPath}/moviesProject"  title="Фильмы"> ФИЛЬМЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/actors"><A href="${pageContext.request.contextPath}/actors" title="Актеры"> АКТЕРЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/reviews"><A href="${pageContext.request.contextPath}/reviews"  title="Отзывы"> ОТЗЫВЫ </A></li>
    <li class="active" method="post" action="${pageContext.request.contextPath}/users"><A href="${pageContext.request.contextPath}/users"  title="Отзывы"> ПОЛЬЗОВАТЕЛИ </A></li>
    </div>
</ul>
<br>
<div class="container-fluid bs-cont">
    <div class="col-md-6 bs-col"> <br>
        <h1>Пользователи</h1>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/users">
            <button type="submit" class="btn btn-primary btn-lg" > Все пользователи </button>
        </form>
        <br>
    </div>
</div>
</body>
</html>

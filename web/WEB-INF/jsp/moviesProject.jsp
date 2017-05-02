<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-pills navbar navbar-default navbar-fixed-top">
    <div class="container"></div>
    <li class="active" method="post" action="${pageContext.request.contextPath}/moviesProject"><A
            href="${pageContext.request.contextPath}/moviesProject" title="Фильмы"> ФИЛЬМЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/actors"><A
            href="${pageContext.request.contextPath}/actors" title="Актеры"> АКТЕРЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/reviews"><A
            href="${pageContext.request.contextPath}/reviews" title="Отзывы"> ОТЗЫВЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/users"><A
            href="${pageContext.request.contextPath}/users" title="Отзывы"> ПОЛЬЗОВАТЕЛИ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/users"><A
            href="${pageContext.request.contextPath}/logout" title="Выход"> ВЫХОД -
        <strong>${sessionScope.user}</strong></A></li>
    </div>
</ul>
<br>
<div class="container-fluid bs-cont">
    <div class="col-md-5 bs-col">
        <br>
        <br>
        <div class="alert alert-success">
            <h1 align="center">Фильмы</h1>
        </div>

        <div class="jumbotron">
            <h3>Добавить фильм</h3>
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/moviesProject">
                <div class="control-group">
                    <label class="control-label" for="inputName">Введите название фильма</label>
                    <div class="controls">
                        <input type="text" id="inputName" name="nameMovie" placeholder="Имя">
                    </div>
                    <br>
                    <label class="control-label" for="genres">Выберете жанр фильма</label>
                    <select name="genres" id="genres">
                        <c:forEach items="${requestScope.genres}" var="genres">
                            <option value="${genres.id}">${genres.name} </option>
                        </c:forEach>
                    </select>
                    <br>
                    <label class="control-label" for="countries">Выберете страну</label>
                    <select name="countries" id="countries">
                        <c:forEach items="${requestScope.countries}" var="countries">
                            <option value="${countries.id}">${countries.name} </option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputDate">Дата выхода фильма</label>
                    <div class="controls">
                        <input type="text" id="inputDate" name="dateOfMovie" placeholder="1960.01.01">
                    </div>
                    <br>
                </div>
                <br>
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-primary btn-lg"> Сохранить фильм в базе</button>
                    </div>
                </div>
            </form>
            <br>
            <br>
        </div>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/movies-full-info2">
            <div class="jumbotron">
                <div class="container">
                    <select name="yearSelect">
                        <c:forEach items="${requestScope.year}" var="year">
                            <option value="${year.dateReleaseMovie}">${year.dateReleaseMovie}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>
                    <button type="submit" class="btn btn-primary btn-lg"> Фильмы в этом году </button>
                    <br>
                </div>
                <br>
                <div class="well well-lg">
                    <ol>
                        <p>
                            <c:forEach items="${requestScope.movies_year}" var="movies_year">
                        <li>
                            <a href="${pageContext.request.contextPath}/movies-full-info2?id=${movies_year.name}">${movies_year.name}</a>
                        </li>
                        </c:forEach>
                        </p>
                    </ol>
                    <%--<h3 class="text-success">Детальное описание.</h3>--%>
                    <%--<p> Имя: <strong>${requestScope.movies_year.namePeople}</strong></p>--%>
                    <%--<p> Год: <strong>${requestScope.movies_year.familyPeople}</strong></p>--%>
                    <p class="text-success"><strong> ${requestScope.people_full.rolePeople} </strong></p>
                </div>
            </div>
        </form>
        <br>
        <br>
    </div>
    <div class="col-md-5 bs-col">
        <br>
        <br>
        <div class="alert alert-success">
            <h1 align="center">Список фильмов</h1>
        </div>
        <div class="jumbotron">
            <div class="container">
                <ol>
                    <p>
                        <c:forEach items="${requestScope.movies}" var="movies">
                    <li>
                        <a href="${pageContext.request.contextPath}/movies-full-info2?id=${movies.id}">${movies.nameMovie}</a>
                    </li>
                    </c:forEach>
                    </p>
                </ol>
            </div>
        </div>
    </div>
</div>
</body>
</html>

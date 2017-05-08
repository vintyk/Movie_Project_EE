<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Reviews</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        body {
            background-image: url(/resources/images/maxresdefault.jpg);
        }
    </style>
</head>
<body>
<ul class="nav nav-pills navbar navbar-default navbar-fixed-top">
    <div class="container"></div>
    <li method="post" action="${pageContext.request.contextPath}/moviesProject"><A
            href="${pageContext.request.contextPath}/moviesProject" title="Фильмы"> ФИЛЬМЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/actors"><A
            href="${pageContext.request.contextPath}/actors" title="Актеры"> АКТЕРЫ </A></li>
    <li class="active" method="post" action="${pageContext.request.contextPath}/reviews"><A
            href="${pageContext.request.contextPath}/reviews" title="Отзывы"> ОТЗЫВЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/users"><A
            href="${pageContext.request.contextPath}/users" title="Отзывы"> ПОЛЬЗОВАТЕЛИ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/users"><A
            href="${pageContext.request.contextPath}/logout" title="Выход"> ВЫХОД -
        <strong>${sessionScope.user}</strong></A></li>

    <c:if test="${sessionScope.privilege eq '1'}">
        <li method="post" action="${pageContext.request.contextPath}/adminTool"><A
                href="${pageContext.request.contextPath}/adminTool" title="Отзывы"> АДМИНИСТРАТОР </A></li>
    </c:if>
    </div>
</ul>
<br>
<div class="container-fluid bs-cont">
    <div class="col-md-4 bs-col">
        <br>
        <br>

            <h1 align="center">Отзывы</h1>

        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/reviews">
            <button class="btn btn-large btn-block btn-primary" type="submit" name="reviewsFullInfo" onclick="1"
                    value="reviewsFullInfo" )>Просмотреть отзывы о фильме
            </button>
            <br>
            <select name="moviesId">
                <c:forEach items="${requestScope.movies}" var="movies">
                    <option value="${movies.id}">${movies.nameMovie}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <button class="btn btn-large btn-block" type="submit" name="createReview" onclick="2" value="createReview">
                Оставить отзыв о фильме
            </button>
            <br>
            <textarea rows="5" name="comment_user" class="form-control"></textarea>
            <br>
            <select name="rank">
                <option value="1">Оценить на 1</option>
                <option value="2">Оценить на 2</option>
                <option value="3">Оценить на 3</option>
                <option value="4">Оценить на 4</option>
                <option value="5">Оценить на 5</option>
            </select>
        </form>
    </div>
    <div class="col-md-6 bs-col">
        <br>
        <br>

            <h1 align="center">Отзывы о фильме</h1>
            <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/getFile">
                <button class="btn btn-success" type="submit" name="createReview" onclick="2" value="createReview">
                    Сформировать Отчет об отзывах.
                </button>
            </form>
            <div class="panel panel-success">
                <div class="container">
                    <div id="" style="overflow-y:scroll; overflow-x:hidden; height:576px;">
                        <ol>
                            <p>

                                <c:forEach items="${requestScope.review_full}" var="review_full">
                                <li>
                            <p> Отзыв пользователя: ${review_full.nameUser} ${review_full.familyUser} </p>
                            <p> Его оценка фильму: ${review_full.rank}                                </p>
                            <p> Комментарий к фильму: ${review_full.comment_user}                     </p>
                            </li>
                            </c:forEach>
                            </p>
                        </ol>
                    </div>
                </div>
            </div>

    </div>
</div>
</body>
</html>
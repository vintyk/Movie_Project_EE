<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>Movie-full-Info</title>
    <style>
        body {
            background-image: url(/resources/images/maxresdefault.jpg);
        }
    </style>
</head>
<body>

<div class="container-fluid bs-cont">
    <div class="col-md-6 bs-col"><br>
        <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/moviesProject">
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-success btn-lg"> На главную</button>
                </div>
            </div>
        </form>
        <h1>Состав фильма</h1>

        <div class="jumbotron">
            <div class="container">
                <ol>
                    <p>
                        <c:forEach items="${requestScope.moviesPeople_full}" var="moviesPeople">
                        <li>
                            <a href="${pageContext.request.contextPath}/people-full-info?id=${moviesPeople.peopleId}">${moviesPeople.namePeople} ${moviesPeople.familyPeople}</a>
                    <p class="text-success"><strong> ${moviesPeople.nameRole} </strong></p>
                    </li>
                    </c:forEach>
                    </p>
                </ol>
                <%--<p> Фамилия: ${requestScope.movies_full.familyPeople}</p>--%>
                <%--<p> Отчество: ${requestScope.people_full.sNamePeople} </p>--%>
                <%--<p> Год рождения: ${requestScope.movies_full.dateOfBirthPeople}</P>--%>
                <%--<p> ${requestScope.movies_full.rolePeople} </p>--%>
            </div>
        </div>

    </div>
</div>
</body>
</html>

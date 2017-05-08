<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>People-full-Info</title>
    <style>
        body {
            background-image: url(/resources/images/maxresdefault.jpg);
        }
    </style>
</head>
<body>

<div class="container-fluid bs-cont">
    <div class="col-md-6 bs-col"><br>
        <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/actors">
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-success btn-lg"> Актеры </button>
                </div>
            </div>
        </form>
        <h1>Актер</h1>

        <div class="jumbotron">
            <div class="container">
                <P> Имя: ${requestScope.people_full.namePeople}
                <p> Фамилия: ${requestScope.people_full.familyPeople}</p>
                <p> Отчество: ${requestScope.people_full.sNamePeople} </p>
                <p> Год рождения: ${requestScope.people_full.dateOfBirthPeople}</P>
                <p> ${requestScope.people_full.rolePeople} </p>
            </div>
        </div>

    </div>
</div>
</body>
</html>

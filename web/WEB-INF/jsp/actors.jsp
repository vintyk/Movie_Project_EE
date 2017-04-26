<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <li method="post" action="${pageContext.request.contextPath}/moviesProject"><A
            href="${pageContext.request.contextPath}/moviesProject" title="Фильмы"> ФИЛЬМЫ </A></li>
    <li class="active" method="post" action="${pageContext.request.contextPath}/actors"><A
            href="${pageContext.request.contextPath}/actors" title="Актеры"> АКТЕРЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/reviews"><A
            href="${pageContext.request.contextPath}/reviews" title="Отзывы"> ОТЗЫВЫ </A></li>
    <li method="post" action="${pageContext.request.contextPath}/users"><A
            href="${pageContext.request.contextPath}/users" title="Отзывы"> ПОЛЬЗОВАТЕЛИ </A></li>
    </div>
</ul>
<br>

<div class="container-fluid bs-cont">
    <div class="col-md-4 bs-col"><br>
        <h1 align="center">Aктеры</h1>
        <div class="jumbotron">
            <h3>Добавить актера</h3>
            <div class="form-horizontal" method="post" action="${pageContext.request.contextPath}/actors">
                <div class="control-group">
                    <label class="control-label" for="inputName">Введите имя актера</label>
                    <div class="controls">
                        <input type="text" id="inputName" name="namePeople" placeholder="Имя">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputFamily">Введите фамилию актера</label>
                    <div class="controls">
                        <input type="text" id="inputFamily" name="familyPeople" placeholder="Фамилия">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputSname">Отчество (если есть)</label>
                    <div class="controls">
                        <input type="text" id="inputSname" name="sNamePeople" placeholder="Отчество">
                    </div>
                    <br>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputDate">Дата рождения</label>
                    <div class="controls">
                        <input type="text" id="inputDate" name="dateOfBirthPeople" placeholder="1960.01.01">
                    </div>
                    <br>
                </div>
                <label class="radio">
                    <input type="radio" name="rolesId" id="optionsRadios1" value="1" checked>
                    Актер.
                </label>
                <label class="radio">
                    <input type="radio" name="rolesId" id="optionsRadios2" value="2">
                    Режисер.
                </label>
                <br>

                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-primary btn-lg"> Сохранить актера в базе</button>
                    </div>
                </div>
            </div>
            <br>
            <br>
        </div>
        </form>

        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/people-full-info2">

            <div class="jumbotron">
                <div class="container">
                    <select name="peopleListDropdown">
                        <c:forEach items="${requestScope.people}" var="people">
                            <option value="${people.id}">${people.name} ${people.family}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>
                    <button type="submit" class="btn btn-primary btn-lg"> Выбрать актера</button>
                    <br>
                </div>
                <br>
                <div class="well well-lg">
                    <h3 class="text-success">Детальное описание.</h3>
                    <p> Имя: <strong>${requestScope.people_full.namePeople}</strong></p>
                    <p> Фамилия: <strong>${requestScope.people_full.familyPeople}</strong></p>
                    <p> Отчество: <strong>${requestScope.people_full.sNamePeople}</strong></p>
                    <p> Год рождения: <strong>${requestScope.people_full.dateOfBirthPeople}</strong></p>
                    <p class="text-success"><strong> ${requestScope.people_full.rolePeople} </strong></p>
                </div>
            </div>
        </form>
        <br>
        <br>
    </div>
    <div class="col-md-5 bs-col">
        <br>
        <h1 align="center">Визитные карточки актеров</h1>


        <div class="jumbotron">
            <div class="container">

                <c:forEach items="${requestScope.people}" var="people">
                    <p>
                        <a href="${pageContext.request.contextPath}/people-full-info?id=${people.id}">${people.name} ${people.family}</a>
                    </p>
                </c:forEach>


            </div>
        </div>

    </div>
</div>
</body>
</html>

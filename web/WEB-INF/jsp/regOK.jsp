<%@ page import="video.dao.UsersDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>Registration Ok!</title>
</head>
<body>
<div class="container-fluid bs-cont">
    <h1>Вы успешно зарегистрировались!</h1>
    <div class="col-md-4 bs-col">
        User:  <%= UsersDao.getInstance().getById(1)%><br>
    </div>
    <div class="col-md-8 bs-col">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/login">
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-success btn-lg"> В Х О Д</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
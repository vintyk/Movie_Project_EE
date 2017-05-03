<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.localLang}"/>
<fmt:setBundle basename="translation"/>
<html>
<head>
    <title>LOGIN</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
 <!-- Не работает вставка картинки -->
 <!-- <img  src="/img/login.png" border="0"  alt="login" > -->
<br>
<h3 class="col-md-4 bs-col">
    <br>
    <br>
    <div class="alert alert-success">
<h1 align="center"><fmt:message key="EnterSys"/></h1>
    </div>
    <br>
    <strong><em><fmt:message key="${message}"/></em></strong>
    <br>
    <br>
    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/login">
        <div class="control-group">
            <label class="control-label" for="inputEmail"><fmt:message key="EnterUser"/></label>
            <div class="controls">
                <input type="text" id="inputEmail" name="inputEmail" placeholder="E-mail">
            </div>
        </div>
        <br>
        <div class="control-group">
            <label class="control-label" for="inputPassword"><fmt:message key="EnterPass"/></label>
            <div class="controls">
                <input type="password" id="inputPassword" name="inputPassword" placeholder="Password">
            </div>
        </div>
        <label class="checkbox">
            <input type="checkbox"> <fmt:message key="remember"/>
        </label>
        <br>
        <br>
        <select onchange="submit()" name="lang">
            <option value="ru_RU" ${sessionScope.localLang eq 'ru_RU' ? 'selected':''}>Русский</option>
            <option value="en_US" ${sessionScope.localLang eq 'en_US' ? 'selected':''}>English</option>
        </select>
        <br>
        <br>
        <button class="btn btn-primary btn-lg" data-toggle="modal" > <fmt:message key="EnterSys"/> </button>
    </form>
    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/registration">
        <br>
        <button class="btn btn-primary btn-lg" data-toggle="modal"> <fmt:message key="registration"/> </button>
    </form>

<!--    <c:if test="${sessionScope.privilege eq '1'}"> админ </c:if>
        <c:if test="${sessionScope.privilege eq '2'}"> юзер </c:if>    -->
</div>
</body>
</html>

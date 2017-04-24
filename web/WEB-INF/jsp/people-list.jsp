<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>People</title>

</head>
<body>
<div class="container">
    <c:forEach items="${requestScope.people}" var="people">
        <p><a href="${pageContext.request.contextPath}/show-people-details?id=${people.id}">${people.name}  ${people.family}</a></p>
    </c:forEach>
</div>
</body>
</html>

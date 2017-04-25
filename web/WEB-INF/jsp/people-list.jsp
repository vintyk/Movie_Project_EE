<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>People</title>

</head>
<body>

    <div class="container">
    <select>
    <c:forEach items="${requestScope.people}" var="people">
    <option><p><a href="${pageContext.request.contextPath}/people-full-info?id=${people.id}">${people.name}  ${people.family}</a></p></option>
    </c:forEach>
    </select>
    </div>

</body>
</html>

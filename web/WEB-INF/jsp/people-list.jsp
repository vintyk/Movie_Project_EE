<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>People</title>
</head>
<body>
 <!--
    <select>
    <c:forEach items="${requestScope.people}" var="people">
    <option><p><a href="${pageContext.request.contextPath}/people-full-info?id=${people.id}">${people.name}  ${people.family}</a></p></option>
    </c:forEach>
    </select>
-->
    <c:forEach items="${requestScope.people}" var="people">
        <p><a href="${pageContext.request.contextPath}/people-full-info?id=${people.id}">${people.name}  ${people.family}</a></p>
    </c:forEach>
 <div class="container">

 </div>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>People-full-Info</title>

</head>
<body>
<div class="container">
        ${requestScope.people_full.namePeople}
        ${requestScope.people_full.familyPeople}
        ${requestScope.people_full.sNamePeople}
        ${requestScope.people_full.dateOfBirthPeople}
          ${requestScope.people_full.rolePeople}



</div>
</body>
</html>

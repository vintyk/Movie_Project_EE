<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Тест!!!</title>
  </head>
  <body>
  <h1> Пробую простой пример заполнения страницы с Java кодом </h1>
  <h3>Пример работы с выражениями JSP</h3>
    Текущая дата: <%= new java.util.Date()%>
    <br>
  <%! private int count = 0; %>
  <% String outParameter = request.getHeader("User-Agent");
    if (outParameter.contains("Chrome")){%>
  <%=  outParameter = "Вы  в Хроме " %> <br>
  <% }  %>
  <br>
  outParameter
  Страница была показана <%= ++count %> раз.
  <br>

    </body>
</html>
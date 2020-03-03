<%--
  Created by IntelliJ IDEA.
  User: melaniemenge
  Date: 28.02.20
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <h1>Log In</h1>
  <form action = "LoginServlet" method = "POST">
    Username: <label>
    <input type = "text" name = "username">
  </label>
    <br />
    Passwort: <label>
    <input type = "password" name = "password" />
  </label>
    <input type = "submit" value = "Submit" />
  </form>
  </body>
</html>

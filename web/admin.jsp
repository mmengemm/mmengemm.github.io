<%--
  Created by IntelliJ IDEA.
  User: melaniemenge
  Date: 28.02.20
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Optionen:</h1>
<form name= "form" action="Servlet" method = "POST">
    <input type="hidden" name="hidden">
    <input type="button" name="mitarbeiter" value="neuer Mitarbeiter erstellen"
           onclick="{document.form.hidden.value=this.value;document.form.submit()}">
    <input type="button" name="kunde" value="neuer Kunde erstellen"
           onclick="{document.form.hidden.value=this.value;document.form.submit()}">
    <input type="button" name="baustelle" value="neue Baustelle erstellen"
           onclick="{document.form.hidden.value=this.value;document.form.submit()}">
</form>
</body>
</html>

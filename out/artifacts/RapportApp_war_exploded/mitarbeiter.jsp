<%--
  Created by IntelliJ IDEA.
  User: melaniemenge
  Date: 28.02.20
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Neuen Mitarbeiter erstellen</title>
</head>
<body>
<h1>neuer Mitarbeiter erstellen</h1>
<form action = "Servlet" name="maform" method = "POST">
    <input type="hidden" name="hidden">
    Vorname: <label>
    <input type = "text" name = "Vorname">
</label>
    <br />
    Nachname: <label>
    <input type = "text" name = "Nachname" />
</label>
    <br />
    Adresse: <label>
    <input type = "text" name = "Adresse" />
</label>
    <br />
    E-Mail: <label>
    <input type = "text" name = "Email" />
</label>
    <br />
    AHV-Nr: <label>
    <input type = "text" name = "AHV" />
</label>
    <input type = "button" name="mitarbeiter erstellen" value = "Mitarbeiter jetzt erstellen"
           onclick="{document.maform.hidden.value=this.value;document.maform.submit()}"/>
</form>
</body>
</html>

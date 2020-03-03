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
    <title>Neuen Kunden erstellen</title>
</head>
<body>
<form action = "Servlet" name= "kuform" method = "POST">
    <input type="hidden" name="hidden"/>
    Kunde: <label>
    <input type = "text" name = "Kunde">
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
    <input type = "button" value = "Kunde jetzt erstellen"
           onclick="{document.kuform.hidden.value=this.value;document.kuform.submit()}"/>
</form>
</body>
</html>

<%@ page import="javax.xml.transform.Result" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: melaniemenge
  Date: 28.02.20
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Neue Baustelle erfassen</title>
</head>
<body>
<form action = "Servlet" name="baform" method = "POST">
    <input type="hidden" name="hidden"/>
    <%
        ResultSet rs;
    %>
    <%
        rs= (ResultSet)request.getAttribute("rsvalue");
    %>
    Kunde:
    <select name="dropdown">
        <option value="default">--All--</option>
        <%
            while(rs.next())
            {
        %>
        <option value="<%=rs.getString("id")%>"><%=rs.getString("Kunde")%> </option>
        <%
            }
        %>
    </select>

    <br />
    Adresse: <label>
    <input type = "text" name = "Adresse" />
</label>
    <br />
    <input type = "button" value = "Baustelle jetzt erfassen"
           onclick="{document.baform.hidden.value=this.value;document.baform.submit()}"/>
</form>

</body>
</html>


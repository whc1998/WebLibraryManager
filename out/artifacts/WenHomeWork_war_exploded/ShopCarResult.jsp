<%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/6
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShopCarResult</title>
</head>
<body>

    <%
        String message= (String) request.getAttribute("message");
    %>

    <div align="center">
        <h1><%=message%></h1>
        <a href="BookView.jsp">back</a>
    </div>

</body>
</html>

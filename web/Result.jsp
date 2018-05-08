<%@ page import="LibaryManager.BookManger" %><%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/4
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
       String message= (String) request.getAttribute("Message");
    %>

    <h1><%=message%></h1>

   <a href="BookView.jsp">返回</a>

</body>
</html>

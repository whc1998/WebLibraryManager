<%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/8
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书</title>
</head>
<body>
<div align="center" style="width: auto;">

    <h1>修改图书</h1>

    <form action="UpdateBookServlet" method="post">
        旧图书名：<input type="text" name="oldBookName" value="<%=request.getParameter("bookName")%>"><br>
        新图书名：<input type="text" name="newBookName" value=""><br>
        新作者：<input type="text" name="newBookAuthor" value=""><br>
        新价格：<input type="text" name="newBookPrice" value=""><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>

</div>
</body>
</html>

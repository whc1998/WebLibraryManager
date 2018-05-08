<%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/3
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<div align="center" style="width: auto">
    <h1>添加图书</h1>

    <form action="AddBookServlet" method="post">
        <%--图书Id：<input type="text" name="bookid"/><br>--%>
        图 书 名：<input type="text" name="bookName"/><br>
        图书作者：<input type="text" name="bookAuthor"/><br>
        图书价格：<input type="text" name="bookPirce"/><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>

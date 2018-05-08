<%@ page import="java.util.List" %>
<%@ page import="LibaryManager.Book" %><%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/6
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShopCar</title>
</head>
<body>

<div align="center">
    <h1>购物车</h1>
    <table border="1"  width="auto">
        <thead>
        <tr>
            <td>图书编号</td>
            <td>图书名</td>
            <td>图书作者</td>
            <td>图书价格</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <%
            List<Book> shopCar = (List<Book>) session.getAttribute("shopCar");
            if (shopCar==null) {
        %>

        <a>购物车为空</a>

        <%
        } else {
            int size = shopCar.size();
            for (int i = 0; i < size; i++) {
                Book book = shopCar.get(i);
        %>
        <tr>
            <td><%=i + 1%>
            </td>
            <td><%=book.bookname%>
            </td>
            <td><%=book.bookAuthor%>
            </td>
            <td><%=book.bookprice%>
            </td>
            <td>
                <a href="">删除</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <a href="BookView.jsp">返回</a>

</div>
</body>
</html>

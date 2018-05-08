<%@ page import="LibaryManager.BookManger" %>
<%@ page import="java.util.List" %>
<%@ page import="LibaryManager.Book" %><%--
  Created by IntelliJ IDEA.
  User: WSY
  Date: 2018/5/3
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
</head>
<body>

<div align="center" style="width: auto">

    <h1>图书管理系统</h1>

    <%
        String userName = (String) session.getAttribute("userName");
    %>
    <h3><%=userName%>,welcome!</h3>

    <table border="1">
        <thead>
        <tr>
            <td>书籍id</td>
            <td>书籍名称</td>
            <td>书籍作者</td>
            <td>书籍价格</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <%
            BookManger bookManger = new BookManger();
            List<Book> bookList = bookManger.getBook();
            for (Book book : bookList) {

        %>
        <tr>
            <td><%=book.id%></td>
            <td><%=book.bookname%></td>
            <td><%=book.bookAuthor%></td>
            <td><%=book.bookprice%></td>
            <td>
                <a href="UpdateBookView.jsp?bookName=<%=book.bookname%>">update</a>
                <a href="DeleteBookServlet?bookName=<%=book.bookname%>">delete</a>
                <a href="AddShopCarServlet?bookName=<%=book.bookname%>">buy</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>

        <a href="addBook.jsp">添加图书</a>
        <p></p>
        <a href="ShopCar.jsp">购物车</a>

    </table>

</div>
</body>
</html>

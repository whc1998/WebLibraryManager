package Servlet;

import LibaryManager.BookManger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookManger bookManger = new BookManger();
        String bookName = req.getParameter("bookName");
        bookManger.delete(bookName);
        req.setAttribute("Message", "删除成功!");
        req.getRequestDispatcher("Result.jsp").forward(req,resp);
    }

}

package Servlet;

import LibaryManager.BookManger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookManger bookManger = new BookManger();
        String bookName = req.getParameter("bookName");
        String bookAuthor = req.getParameter("bookAuthor");
        float bookPirce = Float.parseFloat(req.getParameter("bookPirce"));
        boolean add = bookManger.add(bookName, bookAuthor, bookPirce);
        if (add) {
            req.setAttribute("Message", "添加成功!");
        } else {
            req.setAttribute("Message", "该书已经存在!");
        }
        req.getRequestDispatcher("Result.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

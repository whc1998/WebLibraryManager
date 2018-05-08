package Servlet;

import LibaryManager.BookManger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookManger bookManger = new BookManger();
        String oldBookname=req.getParameter("oldBookName");
        String bookName = req.getParameter("newBookName");
        String bookAuthor = req.getParameter("newBookAuthor");
        String pirce=req.getParameter("newBookPrice");
        bookManger.update(oldBookname,bookName,bookAuthor,pirce);
        req.setAttribute("Message", "修改成功!");
        req.getRequestDispatcher("Result.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

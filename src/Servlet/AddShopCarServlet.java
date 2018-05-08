package Servlet;

import LibaryManager.Book;
import LibaryManager.BookManger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddShopCarServlet")
public class AddShopCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String bookName=req.getParameter("bookName");
        BookManger bookManger=new BookManger();
        Book book= bookManger.selectBook(bookName);
        List<Book> shopCar = (List<Book>) session.getAttribute("shopCar");
        if (shopCar==null){
            shopCar=new ArrayList<>();
            if (book!=null){
                shopCar.add(book);
                req.setAttribute("message","add suecces!");
            }
        }else {
            if (shopCar.contains(book)){
                req.setAttribute("message","this book is init!");
            }else{
                shopCar.add(book);
                req.setAttribute("message","add suecces!");
            }
        }
        session.setAttribute("shopCar",shopCar);
        req.getRequestDispatcher("ShopCarResult.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

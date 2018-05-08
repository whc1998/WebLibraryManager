package Servlet;

import LibaryManager.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/Servlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1l;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement pstmt = null;
        Connection connection=null;
        try {
            connection = DBHelper.getConnection();
            String userId = req.getParameter("userId");
            String password = req.getParameter("passWord");
            String sql = "select name from user where userid=? and password=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                req.getSession().setAttribute("userName", resultSet.getString("name"));
                req.getRequestDispatcher("BookView.jsp").forward(req, resp);
            } else {
                req.setAttribute("answer", resultSet.getString("name"));
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

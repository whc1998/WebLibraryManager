package LibaryManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookManger {

    private Connection connection = null;
    private Statement statement = null;

    public BookManger() {
        try {
            connection = DBHelper.getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBook() {
        String sql = "select * from Book";
        ResultSet resultSet = null;
        List<Book> bookList = new ArrayList<>();
        int i = 1;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book(i, resultSet.getString("bookName"),
                        resultSet.getString("author")
                        , resultSet.getDouble("price"));
                i++;
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public boolean add(String booknaem, String author, float price) {
        ResultSet resultSet = null;
        String checksql = "select * from Book where bookName='" + booknaem + "'";
        try {
            resultSet = statement.executeQuery(checksql);
            if (resultSet.next()) {
                System.out.println("该书以及存在");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into Book values ( '" + booknaem + "','" + author + "','" + price + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Book selectBook(String bookName) {
        ResultSet resultSet = null;
        Book book = null;
        String checksql = "select * from Book where bookName='" + bookName + "'";
        try {
            resultSet = statement.executeQuery(checksql);
            if (resultSet.next()) {
                book = new Book(0, resultSet.getString("bookName"),
                        resultSet.getString("author")
                        , resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void delete(String bookname) {
        String sql = "delete from Book where bookName='" + bookname + "'";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String updatename, String bookname, String author, String price) {
        String sql = "update Book set bookName='" + bookname + "'," + "author='" + author + "'," + "price='" + price +
                "' where bookName='" + updatename + "'";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stopconnection() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

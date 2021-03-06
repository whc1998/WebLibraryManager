package LibaryManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static final String driver = "com.mysql.jdbc.Driver";
    //连接数据库的url地址
    private static final String url = "jdbc:mysql://localhost:3306/Book?useUnicode=true&characterEncoding=UTF8";
    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection = null;

    //静态代码块负责加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //单例模式返回数据库对象
    public static Connection getConnection() throws Exception {
        if (connection == null) {
            synchronized (Connection.class) {
                if (connection == null) {
                    connection = DriverManager.getConnection(url, username, password);
                }
            }
        }
        return connection;
    }

    public void stopConnection() throws SQLException {
        connection.close();
    }

}

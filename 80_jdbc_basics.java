import java.sql.*;

// 80_jdbc_basics.java - beginner-friendly example for 80 jdbc basics
public class 80JdbcBasics {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test"; Connection connection = DriverManager.getConnection(url, "user", "pass"); System.out.println("Connected: " + (connection != null)); if (connection != null) connection.close();
    }
}

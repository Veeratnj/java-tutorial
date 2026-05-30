import java.sql.*;

// 81_jdbc_crud.java - beginner-friendly example for 81 jdbc crud
public class 81JdbcCrud {
    public static void main(String[] args) {
        String sql = "INSERT INTO users (name) VALUES (?)"; try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "pass")) { PreparedStatement stmt = conn.prepareStatement(sql); stmt.setString(1, "Ava"); int rows = stmt.executeUpdate(); System.out.println("Inserted rows: " + rows); }
    }
}

package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Demo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        String insertSql = "INSERT INTO students (name, department) VALUES (?, ?)";
        String selectSql = "SELECT id, name, department FROM students";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            System.out.println("MySQL Connected Successfully!");

            try (PreparedStatement insert = con.prepareStatement(insertSql)) {
                insert.setString(1, "Baskar");
                insert.setString(2, "CSE");
                int rows = insert.executeUpdate();
                System.out.println(rows + " record inserted.");
            }

            System.out.println("\nStudent Records:");
            try (PreparedStatement select = con.prepareStatement(selectSql);
                 ResultSet rs = select.executeQuery()) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getString("department")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection or query failed.");
            e.printStackTrace();
        }
    }
}

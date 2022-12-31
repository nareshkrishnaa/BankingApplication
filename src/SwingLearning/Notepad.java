/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.sql.*;

public class Notepad {

    public static void main(String args[]) {

        System.out.println(5 + 5);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankingapplication", "root", "password")) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Login");
                var username = "zayn";
                String password = "1234";
                int count = 0;
                while (rs.next()) {
                    count++;
                    System.out.println(rs.getString(1) + "  " + rs.getString(2));
                    if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
                        System.out.println("User name exists at " + count + "th position proceed to next page");
                    }

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

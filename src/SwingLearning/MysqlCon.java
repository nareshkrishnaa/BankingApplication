
import java.sql.*;

class MysqlCon {

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test1", "root", "password")) {
                //here sonoo is database name, root is username and password
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from table1");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

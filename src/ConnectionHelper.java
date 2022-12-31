/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionHelper {

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPortNumber() {
        return portNumber;
    }
    
    public Statement getNewStatement(){
        try {
            return this.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String userName="root";
    private String password="password";
    private String dataBaseName="bankingapplication";
    private String hostName="localhost";
    private int portNumber=3306;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",
                    this.getHostName(),this.getPortNumber(),this.getDataBaseName()),this.getUserName(), this.getPassword());
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Exception thrown in ConnectionHelper " + e);
                }
        return null;
    }

}

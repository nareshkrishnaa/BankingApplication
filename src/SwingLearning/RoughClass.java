package SwingLearning;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import main.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class RoughClass {
    public static void main(String args[]) throws SQLException{
        ConnectionHelper ch =new ConnectionHelper();
            Connection con =ch.getConnection();
            Statement stmt = con.createStatement();
            
            String query="select bankbalance from customerdetails where emailId='ank@123' and password='234';";
            System.out.println(query);
           ResultSet result= stmt.executeQuery(query);
           if(result.next())
           System.out.println(result.getString("BankBalance"));
           else{
           System.out.println("Data not found");
                   }     
                   
                   
    }
}
